package pl.bratek20.keyvaluestorage.web.dto;

import pl.bratek20.keyvaluestorage.api.Value;

public record ValueDto(String value) {
    public Value toApi() {
        return new Value(value);
    }
}
