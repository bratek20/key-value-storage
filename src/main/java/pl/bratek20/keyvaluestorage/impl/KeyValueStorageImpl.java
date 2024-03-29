package pl.bratek20.keyvaluestorage.impl;

import pl.bratek20.keyvaluestorage.api.*;

import java.util.ArrayList;
import java.util.Comparator;
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
                .orElseThrow(KeyNotFoundException::new);
    }

    @Override
    public List<KeyValuePair> getAll() {
        return storage.stream()
                .sorted(Comparator.comparing(kv -> kv.value().value()))
                .toList();
    }

    @Override
    public List<Key> getAllKeys() {
        return storage.stream()
                .map(KeyValuePair::key)
                .toList();
    }
}
