package pl.bratek20.keyvaluestorage.web

import pl.bratek20.commons.http.impl.HttpConfig
import pl.bratek20.keyvaluestorage.api.KeyValueStorage
import pl.bratek20.keyvaluestorage.api.KeyValueStorageTest
import pl.bratek20.keyvaluestorage.impl.infra.KeyValueStorageConfig
import pl.bratek20.keyvaluestorage.web.client.KeyValueStorageWebClientConfig
import pl.bratek20.keyvaluestorage.web.server.KeyValueStorageWebServerConfig
import pl.bratek20.spring.context.SpringContextBuilder
import pl.bratek20.spring.data.InMemoryDataConfig
import pl.bratek20.spring.data.dbcleaner.DBCleaner
import pl.bratek20.spring.flyway.impl.FlywayConfig
import pl.bratek20.spring.web.TestWebAppRunner

internal class KeyValueStorageWebTest : KeyValueStorageTest() {
    override fun createApi(): KeyValueStorage {
        TestWebAppRunner(
            FlywayConfig::class.java,
            InMemoryDataConfig::class.java,
            KeyValueStorageConfig::class.java,
            KeyValueStorageWebServerConfig::class.java
        ).run()

        return SpringContextBuilder(
                HttpConfig::class.java,
                KeyValueStorageWebClientConfig::class.java
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