package pl.bratek20.keyvaluestorage.impl;

import pl.bratek20.keyvaluestorage.api.Key;
import pl.bratek20.keyvaluestorage.api.KeyValuePair;
import pl.bratek20.keyvaluestorage.api.KeyValueStorage;
import pl.bratek20.keyvaluestorage.api.Value;

import java.util.ArrayList;
import java.util.List;

public class KeyValueStorageImpl implements KeyValueStorage {
    private final List<KeyValuePair> storage = new ArrayList<>();

    @Override
    public void set(Key key, Value value) {
        storage.add(new KeyValuePair(key, value));
    }

    @Override
    public Value get(Key key) {
        return storage.stream()
                .filter(kv -> kv.key().equals(key))
                .map(KeyValuePair::value)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<KeyValuePair> getAll() {
        return new ArrayList<>(storage);
    }
}
