plugins {
    kotlin("jvm") version "1.9.22"
}

group = "me.blueamethyst.bluecloud"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}