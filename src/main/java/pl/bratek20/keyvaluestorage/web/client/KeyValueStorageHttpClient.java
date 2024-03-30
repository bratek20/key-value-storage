package pl.bratek20.keyvaluestorage.web.client;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import pl.bratek20.commons.http.api.HttpClient;
import pl.bratek20.commons.http.api.HttpClientFactory;
import pl.bratek20.keyvaluestorage.api.*;
import pl.bratek20.keyvaluestorage.web.dto.*;

import java.util.List;

@RequiredArgsConstructor
public class KeyValueStorageHttpClient implements KeyValueStorage {
    private final HttpClientFactory factory;

    @Setter
    private int port;

    @Override
    public void set(Key key, Value value) {
        client().post("/set", new SetRequest(key.value(), value.value()));
    }

    @Override
    public Value get(Key key) throws KeyNotFoundException {
        var response = client().post("/get", new GetRequest(key.value()));

        if (response.getStatusCode() == 500) {
            throw new KeyNotFoundException();
        }

        return response.getBody(ValueDto.class)
            .toApi();
    }

    @Override
    public List<KeyValuePair> getAll() {
        return client().get("/get-all")
            .getBody(GetAllResponse.class)
            .pairs().stream().map(KeyValuePairDto::toApi).toList();
    }

    @Override
    public List<Key> getAllKeys() {
        return client().get("/get-all-keys")
            .getBody(GetAllKeysResponse.class)
            .keys().stream().map(Key::new).toList();
    }

    private HttpClient client() {
        return factory.create("http://localhost:" + port + "/key-value-storage");
    }
}
