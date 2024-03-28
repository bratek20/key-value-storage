package pl.bratek20.keyvaluestorage.impl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeyValueStorageConfig {
    @Bean
    public KeyValueStorageLogic keyValueStorageLogic() {
        return new KeyValueStorageLogic();
    }
}
