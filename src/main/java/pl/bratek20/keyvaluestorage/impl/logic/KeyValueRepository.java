package pl.bratek20.keyvaluestorage.impl.logic;

import pl.bratek20.keyvaluestorage.api.Key;
import pl.bratek20.keyvaluestorage.api.KeyValuePair;
import pl.bratek20.keyvaluestorage.api.Value;

import java.util.List;
import java.util.Optional;

public interface KeyValueRepository {
    List<KeyValuePair> getAll();

    Optional<Value> findValue(Key key);

    void save(KeyValuePair keyValuePair);
}
