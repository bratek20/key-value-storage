plugins {
    alias(libs.plugins.bratek20.base.conventions)

    alias(libs.plugins.bratek20.spring.app.conventions)

    alias(libs.plugins.jib)
}

dependencies {
    implementation(libs.bratek20.starter)
    testImplementation(testFixtures(libs.bratek20.starter))
}

jib {
    from {
        image = "openjdk:17-slim"
    }
    to {
        image = "key-value-storage:latest"
    }
    container {
        ports = listOf("8080")
        jvmFlags = listOf("-Xms512m", "-Xmx512m")
        mainClass = "pl.bratek20.keyvaluestorage.Main"
    }
}