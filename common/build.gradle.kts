plugins {
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.serialization") version "1.9.23"
}

group = "me.blueamethyst.bluecloud"
version = project.property("project.version").toString()

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.bundles.ktorClient)
    implementation(kotlin("reflect"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}