plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.serialization)
}

group = "me.blueamethyst.bluecloud"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":api"))
    implementation(project(":common"))
    implementation(project(":common:cli"))
    implementation(libs.mordant)
    implementation(libs.guice)
    implementation(libs.kotlinxSerializationJson)
}