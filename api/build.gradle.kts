plugins {
    kotlin("jvm") version "1.9.24"
}

group = "me.blueamethyst.bluecloud"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.guice)
}

kotlin {
    jvmToolchain(21)
}