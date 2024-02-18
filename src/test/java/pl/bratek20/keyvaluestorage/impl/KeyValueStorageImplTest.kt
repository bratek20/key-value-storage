package pl.bratek20.keyvaluestorage.impl

import pl.bratek20.keyvaluestorage.api.KeyValueStorage
import pl.bratek20.keyvaluestorage.api.KeyValueStorageTest

internal class KeyValueStorageImplTest : KeyValueStorageTest() {
    override fun createStorage(): KeyValueStorage {
        return KeyValueStorageImpl()
    }
}