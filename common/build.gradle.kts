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
    implementation(libs.bundles.ktorClient)
    implementation(libs.guice)
    implementation(libs.clikt)
    implementation(libs.mordant)
    implementation(libs.mordantCoroutines)
    implementation(kotlin("reflect"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}