package pl.bratek20.keyvaluestorage.web.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bratek20.commons.http.api.HttpClientFactory;

@Configuration
public class KeyValueStorageWebClientConfig {
    @Bean
    public KeyValueStorageHttpClient keyValueStorageHttpClient(HttpClientFactory factory) {
        return new KeyValueStorageHttpClient(factory);
    }
}
