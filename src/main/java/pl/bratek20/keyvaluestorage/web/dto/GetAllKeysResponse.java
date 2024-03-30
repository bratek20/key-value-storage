package pl.bratek20.keyvaluestorage.web.dto;

import java.util.List;

public record GetAllKeysResponse(
    List<String> keys
) {

}
