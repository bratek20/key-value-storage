package pl.bratek20.keyvaluestorage.impl.logic;

import lombok.RequiredArgsConstructor;
import pl.bratek20.keyvaluestorage.api.*;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class KeyValueStorageLogic implements KeyValueStorage {
    private final KeyValueRepository repository;

    @Override
    public void set(Key key, Value value) {
        repository.save(new KeyValuePair(key, value));
    }

    @Override
    public Value get(Key key) {
        return repository.findValue(key)
            .orElseThrow(KeyNotFoundException::new);
    }

    @Override
    public List<KeyValuePair> getAll() {
        return repository.getAll().stream()
                .sorted(Comparator.comparing(kv -> kv.value().value()))
                .toList();
    }

    @Override
    public List<Key> getAllKeys() {
        return repository.getAll().stream()
                .map(KeyValuePair::key)
                .toList();
    }
}
