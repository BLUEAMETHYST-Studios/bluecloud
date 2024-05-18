plugins {
    kotlin("jvm") version "1.9.24"
}

group = "me.blueamethyst.bluecloud"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":api"))
    implementation(libs.kotlinxCoroutinesCore)
    implementation(libs.guice)
    implementation(kotlin("reflect"))
}

kotlin {
    jvmToolchain(21)
}