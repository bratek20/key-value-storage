plugins {
    alias(libs.plugins.bratek20.base.conventions)
}

dependencies {
    implementation(libs.bratek20.starter)
    testImplementation(testFixtures(libs.bratek20.starter))
}