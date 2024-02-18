package pl.bratek20.keyvaluestorage.api

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import pl.bratek20.keyvaluestorage.fixtures.Assert
import pl.bratek20.keyvaluestorage.fixtures.Setup

abstract class KeyValueStorageTest {
    protected abstract fun createStorage(): KeyValueStorage

    private lateinit var storage: KeyValueStorage
    private lateinit var setup: Setup

    @BeforeEach
    fun beforeEach() {
        storage = createStorage()
        setup = Setup(storage)
    }

    @Test
    fun shouldSetAndGetValue() {
        setup.set {
            key = "key"
            value = "value"
        }

        val result = storage.get(Key("key"))

        Assert.value(result, "value")
    }

    @Test
    fun shouldGetAll() {
        setup.setMany(listOf(
            { key = "key1"; value = "value1" },
            { key = "key2"; value = "value2" }
        ))

        val result = storage.getAll()

        Assert.keyValuePairList(result, listOf(
            { key = "key1"; value = "value1" },
            { key = "key2"; value = "value2" }
        ))
    }

    @Test
    fun shouldGetAllKeys() {
        setup.setMany(listOf(
            { key = "key1" },
            { key = "key2" }
        ))

        val result = storage.getAllKeys()

        Assert.keyList(result, listOf(
            "key1",
            "key2"
        ))
    }

    @Test
    fun keyValuePairsShouldBeSortedByValuesForGetAll() {
        setup.setMany(listOf(
            { key = "key1"; value = "2" },
            { key = "key2"; value = "1" }
        ))

        val result = storage.getAll()

        Assert.keyValuePairList(result, listOf(
            { key = "key2" },
            { key = "key1" }
        ))
    }

    @Test
    fun shouldThrowIfKeyNotFound() {
        assertThrows<KeyNotFoundException> {  storage.get(Key("key"))}
    }
}