package pl.bratek20.keyvaluestorage.impl;

import pl.bratek20.keyvaluestorage.api.KeyValueStorage;
import pl.bratek20.keyvaluestorage.api.KeyValueStorageTest;

class KeyValueStorageImplTest extends KeyValueStorageTest {

    @Override
    protected KeyValueStorage createStorage() {
        return new KeyValueStorageImpl();
    }
}