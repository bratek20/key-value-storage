package pl.bratek20.keyvaluestorage;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import pl.bratek20.keyvaluestorage.impl.infra.KeyValueStorageConfig;
import pl.bratek20.keyvaluestorage.web.server.KeyValueStorageWebServerConfig;
import pl.bratek20.spring.data.InMemoryDataConfig;
import pl.bratek20.spring.flyway.impl.FlywayConfig;
import pl.bratek20.spring.web.WebApp;

@Configuration
@Import({
    FlywayConfig.class,
    InMemoryDataConfig.class,
    KeyValueStorageConfig.class,
    KeyValueStorageWebServerConfig.class
})
public class Main {
    public static void main(String[] args) {
        WebApp.run(Main.class, args);
    }
}
