plugins {
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.serialization") version "1.9.24"
}

group = "me.blueamethyst.bluecloud"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":api"))
    implementation(project(":common"))
    implementation(project(":runner"))
    implementation(libs.kotlinxSerializationCore)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}