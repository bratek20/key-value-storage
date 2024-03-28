package pl.bratek20.keyvaluestorage.impl

import org.junit.jupiter.api.extension.ExtendWith
import pl.bratek20.keyvaluestorage.api.KeyValueStorage
import pl.bratek20.keyvaluestorage.api.KeyValueStorageTest
import pl.bratek20.keyvaluestorage.impl.infra.KeyValueStorageConfig
import pl.bratek20.spring.context.SpringContextBuilder
import pl.bratek20.spring.data.DefaultDataConfig
import pl.bratek20.spring.data.MySQLExtension
import pl.bratek20.spring.data.dbcleaner.DBCleaner
import pl.bratek20.spring.flyway.impl.FlywayConfig

//TODO less code repetition with impl test
@ExtendWith(MySQLExtension::class)
internal class KeyValueStorageIntegrationTest : KeyValueStorageTest() {
    override fun createApi(): KeyValueStorage {
        return SpringContextBuilder(
                FlywayConfig::class.java,
                DefaultDataConfig::class.java,
                KeyValueStorageConfig::class.java
            )
            .build()
            .get(KeyValueStorage::class.java)
    }

    override fun clean() {
        super.clean()

        SpringContextBuilder(
            DefaultDataConfig::class.java,
            DBCleaner::class.java,
        ).build().get(DBCleaner::class.java).deleteAllTables("key_value_storage")
    }
}