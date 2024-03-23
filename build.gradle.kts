plugins {
    id("pl.bratek20.base-conventions") version "1.0.0-SNAPSHOT"

    kotlin("jvm") version "1.9.22"

    id("com.google.protobuf") version "0.9.4"
}

dependencies {
    implementation("com.google.protobuf:protobuf-java:3.25.2")

    testImplementation("pl.bratek20:bratek20-tests:1.0.0-SNAPSHOT")

    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.17.0")

}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.2"
    }
}