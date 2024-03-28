package pl.bratek20.keyvaluestorage.impl

import pl.bratek20.keyvaluestorage.api.KeyValueStorage
import pl.bratek20.keyvaluestorage.api.KeyValueStorageTest
import pl.bratek20.keyvaluestorage.impl.infra.KeyValueStorageConfig
import pl.bratek20.spring.context.SpringContextBuilder
import pl.bratek20.spring.data.InMemoryDataConfig
import pl.bratek20.spring.data.dbcleaner.DBCleaner
import pl.bratek20.spring.flyway.impl.FlywayConfig

internal class KeyValueStorageImplTest : KeyValueStorageTest() {
    override fun createApi(): KeyValueStorage {
        return SpringContextBuilder(
                FlywayConfig::class.java,
                InMemoryDataConfig::class.java,
                KeyValueStorageConfig::class.java
            )
            .build()
            .get(KeyValueStorage::class.java)
    }

    override fun clean() {
        super.clean()

        SpringContextBuilder(
            InMemoryDataConfig::class.java,
            DBCleaner::class.java,
        ).build().get(DBCleaner::class.java).deleteAllTables("key_value_storage")
    }
}