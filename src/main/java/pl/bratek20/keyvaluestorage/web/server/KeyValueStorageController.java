package pl.bratek20.keyvaluestorage.web.server;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.bratek20.keyvaluestorage.api.Key;
import pl.bratek20.keyvaluestorage.api.KeyValueStorage;
import pl.bratek20.keyvaluestorage.api.Value;
import pl.bratek20.keyvaluestorage.web.dto.GetRequest;
import pl.bratek20.keyvaluestorage.web.dto.GetResponse;
import pl.bratek20.keyvaluestorage.web.dto.KeyValuePairDto;
import pl.bratek20.keyvaluestorage.web.dto.SetRequest;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class KeyValueStorageController {
    private final KeyValueStorage storage;

    @PostMapping("/set")
    public void set(SetRequest request) {
        storage.set(new Key(request.key()), new Value(request.value()));
    }

    @PostMapping("/get")
    public GetResponse get(GetRequest request) {
        return new GetResponse(storage.get(new Key(request.key())).value());
    }

    @PostMapping("/getAll")
    public List<KeyValuePairDto> getAll() {
        return storage.getAll().stream().map(KeyValuePairDto::from).toList();
    }

    @PostMapping("/getAllKeys")
    public List<String> getAllKeys() {
        return storage.getAllKeys().stream().map(Key::value).toList();
    }
}
