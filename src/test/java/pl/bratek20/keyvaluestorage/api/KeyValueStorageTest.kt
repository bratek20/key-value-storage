package pl.bratek20.keyvaluestorage.api

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import pl.bratek20.keyvaluestorage.fixtures.Assert
import pl.bratek20.keyvaluestorage.fixtures.Assert.ExpectedKeyValuePair
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

        Assert.assertValue(result, "value")
    }

    @Test
    fun shouldGetAll() {
        setup.setMany(listOf(
            { key = "key1"; value = "value1" },
            { key = "key2"; value = "value2" }
        ))

        val result = storage.getAll()

        Assert.assertKeyValuePairList(
            result,
            listOf(
                ExpectedKeyValuePair("key1", "value1"),
                ExpectedKeyValuePair("key2", "value2")
            )
        )
    }
}