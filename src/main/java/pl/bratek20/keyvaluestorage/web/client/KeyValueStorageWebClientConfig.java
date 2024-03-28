package pl.bratek20.keyvaluestorage.web.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.bratek20.commons.http.api.HttpApi;

@Configuration
public class KeyValueStorageWebClientConfig {
    @Bean
    public KeyValueStorageHttpClient keyValueStorageHttpClient(HttpApi httpApi) {
        return new KeyValueStorageHttpClient(httpApi);
    }
}
