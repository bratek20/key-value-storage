package pl.bratek20.keyvaluestorage.web.server;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bratek20.keyvaluestorage.api.KeyValueStorage;

@Configuration
public class KeyValueStorageWebServerConfig {
    @Bean
    public KeyValueStorageController keyValueStorageController(KeyValueStorage storage) {
        return new KeyValueStorageController(storage);
    }
}
