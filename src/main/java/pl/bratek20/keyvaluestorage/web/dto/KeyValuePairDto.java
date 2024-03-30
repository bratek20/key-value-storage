package pl.bratek20.keyvaluestorage.web.dto;

import pl.bratek20.keyvaluestorage.api.Key;
import pl.bratek20.keyvaluestorage.api.KeyValuePair;
import pl.bratek20.keyvaluestorage.api.Value;

public record KeyValuePairDto(String key, String value) {
    public static KeyValuePairDto from(KeyValuePair pair) {
        return new KeyValuePairDto(pair.key().value(), pair.value().value());
    }

    public KeyValuePair toApi() {
        return new KeyValuePair(new Key(key), new Value(value));
    }
}
