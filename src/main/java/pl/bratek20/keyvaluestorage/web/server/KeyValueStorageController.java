package pl.bratek20.keyvaluestorage.web.server;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.bratek20.keyvaluestorage.api.Key;
import pl.bratek20.keyvaluestorage.api.KeyValueStorage;
import pl.bratek20.keyvaluestorage.api.Value;
import pl.bratek20.keyvaluestorage.web.dto.*;

@RestController
@RequestMapping("/key-value-storage")
@RequiredArgsConstructor
public class KeyValueStorageController {
    private final KeyValueStorage storage;

    @PostMapping("/set")
    public void set(@RequestBody SetRequest request) {
        storage.set(new Key(request.key()), new Value(request.value()));
    }

    @PostMapping("/get")
    public ValueDto get(@RequestBody GetRequest request) {
        return new ValueDto(storage.get(new Key(request.key())).value());
    }

    @GetMapping("/get-all")
    public GetAllResponse getAll() {
        return new GetAllResponse(storage.getAll().stream().map(KeyValuePairDto::from).toList());
    }

    @GetMapping("/get-all-keys")
    public GetAllKeysResponse getAllKeys() {
        return new GetAllKeysResponse(storage.getAllKeys().stream().map(Key::value).toList());
    }
}
