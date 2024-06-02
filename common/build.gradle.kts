plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.serialization)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":api"))
    implementation(project(":common:cli"))
    implementation(project(":common:platforms"))
    implementation(libs.bundles.ktorClient)
    implementation(libs.guice)
    implementation(libs.mordant)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}