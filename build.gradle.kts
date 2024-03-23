plugins {
    id("pl.bratek20.base-conventions") version "1.0.0-SNAPSHOT"

    kotlin("jvm") version "1.9.22"

    id("com.google.protobuf") version "0.9.4"
}

dependencies {
    implementation("pl.bratek20:bratek20-starter:1.0.0-SNAPSHOT")
    testImplementation(testFixtures("pl.bratek20:bratek20-starter:1.0.0-SNAPSHOT"))

    implementation("com.google.protobuf:protobuf-java:3.25.2")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.2"
    }
}