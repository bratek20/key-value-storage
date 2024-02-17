package pl.bratek20.keyvaluestorage.api

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import pl.bratek20.keyvaluestorage.fixtures.Setup

abstract class KeyValueStorageTest {
    protected abstract KeyValueStorage createStorage()

    private KeyValueStorage storage
    private Setup setup

    @BeforeEach
    void beforeEach() {
        storage = createStorage()
        setup = new Setup(storage)
    }

    @Test
    void shouldSetAndGetValue() {
        setup.set {
            key = "key"
            value = "value"
        }

        def result = storage.get(new Key("key"))

        Assert.value(result, "value")
    }

    @Test
    void shouldGetAll() {
        setup.setMany([
                { key = "key1"; value = "value1" },
                { key = "key2"; value = "value2" }
        ])

        def result = storage.getAll()

        Assert.keyValuePairList(result, [
                { key = "key1"; value = "value1" },
                { key = "key2"; value = "value2" }
        ])
    }

    @Test
    void shouldGetAllKeys() {
        setup.setMany([
                { key = "key1" },
                { key = "key2" }
        ])

        def result = storage.getAllKeys()

        Assert.keyList(result, [
                "key1",
                "key2"
        ])
    }

    @Test
    void keyValuePairsShouldBeSortedByValuesForGetAll() {
        setup.setMany([
                { key = "key1"; value = "2" },
                { key = "key2"; value = "1" }
        ])

        def result = storage.getAll()

        Assert.keyValuePairList(result, [
                { key = "key2" },
                { key = "key1" }
        ])
    }
}
