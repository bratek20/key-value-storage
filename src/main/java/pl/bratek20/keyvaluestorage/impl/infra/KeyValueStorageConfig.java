package pl.bratek20.keyvaluestorage.impl.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import pl.bratek20.keyvaluestorage.impl.infra.data.KeyValuePairEntityRepository;
import pl.bratek20.keyvaluestorage.impl.infra.data.KeyValueRepositoryImpl;
import pl.bratek20.keyvaluestorage.impl.logic.KeyValueRepository;
import pl.bratek20.keyvaluestorage.impl.logic.KeyValueStorageLogic;
import pl.bratek20.spring.flyway.api.FlywayMigration;

@Configuration
@EnableJdbcRepositories
public class KeyValueStorageConfig {
    @Bean
    public FlywayMigration flywayMigration() {
        return new FlywayMigration("key_value_storage");
    }

    @Bean
    public KeyValueRepository keyValueStorageRepository(KeyValuePairEntityRepository repository) {
        return new KeyValueRepositoryImpl(repository);
    }

    @Bean
    public KeyValueStorageLogic keyValueStorageLogic(KeyValueRepository repository) {
        return new KeyValueStorageLogic(repository);
    }
}
