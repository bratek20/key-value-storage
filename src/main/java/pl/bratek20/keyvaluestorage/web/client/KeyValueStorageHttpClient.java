package pl.bratek20.keyvaluestorage.web.client;

import lombok.RequiredArgsConstructor;
import pl.bratek20.commons.http.api.HttpApi;
import pl.bratek20.commons.http.api.HttpRequest;
import pl.bratek20.keyvaluestorage.api.*;

import java.util.List;

@RequiredArgsConstructor
public class KeyValueStorageHttpClient implements KeyValueStorage {
    private final HttpApi httpApi;


    @Override
    public void set(Key key, Value value) {
    }

    @Override
    public Value get(Key key) throws KeyNotFoundException {
        return null;
    }

    @Override
    public List<KeyValuePair> getAll() {
        return null;
    }

    @Override
    public List<Key> getAllKeys() {
        return null;
    }
}
