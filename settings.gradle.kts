rootProject.name = "key-value-storage"

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenLocal()
        maven {
            url = uri("https://maven.pkg.github.com/bratek20/starter")
        }
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
        maven {
            url = uri("https://maven.pkg.github.com/bratek20/starter")
        }
    }
}



