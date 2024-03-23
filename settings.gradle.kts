rootProject.name = "key-value-storage"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenLocal()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            from("pl.bratek20:version-catalog:1.0.0-SNAPSHOT")
        }
    }

    repositories {
        mavenLocal()
    }
}



