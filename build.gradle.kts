plugins {
    id("java")

    kotlin("jvm") version "1.9.22"

    id("com.google.protobuf") version "0.9.4"
}

group = "pl.bratek20"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    implementation("com.google.protobuf:protobuf-java:3.25.2")

    testImplementation("pl.bratek20:bratek20-tests:1.0.0")
}

protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.25.2"
    }
}

tasks.test {
    useJUnitPlatform()
}