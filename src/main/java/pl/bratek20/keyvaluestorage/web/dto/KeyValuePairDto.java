package pl.bratek20.keyvaluestorage.web.dto;

import pl.bratek20.keyvaluestorage.api.KeyValuePair;

public record KeyValuePairDto(String key, String value) {
    public static KeyValuePairDto from(KeyValuePair pair) {
        return new KeyValuePairDto(pair.key().value(), pair.value().value());
    }
}
