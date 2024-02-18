package pl.bratek20.keyvaluestorage.api;

import java.util.List;

public interface KeyValueStorage {
    void set(Key key, Value value);

    Value get(Key key)
        throws KeyNotFoundException;

    List<KeyValuePair> getAll();
    List<Key> getAllKeys();
}
