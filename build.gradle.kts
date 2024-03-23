plugins {
    alias(libs.plugins.bratek20.base.conventions)

    alias(libs.plugins.protobuf)
}

dependencies {
    implementation(libs.bratek20.starter)
    testImplementation(testFixtures(libs.bratek20.starter))

    implementation(libs.protobuf.java)
}

protobuf {
    protoc {
        artifact = libs.protobuf.protoc.get().toString()
    }
}