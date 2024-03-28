package pl.bratek20.keyvaluestorage.impl

import pl.bratek20.keyvaluestorage.api.KeyValueStorage
import pl.bratek20.keyvaluestorage.api.KeyValueStorageTest
import pl.bratek20.spring.context.SpringContextBuilder

internal class KeyValueStorageImplTest : KeyValueStorageTest() {
    override fun createStorage(): KeyValueStorage {
        return SpringContextBuilder(KeyValueStorageConfig::class.java)
            .build()
            .get(KeyValueStorage::class.java)
    }
}