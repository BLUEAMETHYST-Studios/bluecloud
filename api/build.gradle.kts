plugins {
    kotlin("jvm") version "1.9.24"
    `maven-publish`
}

group = "me.blueamethyst.bluecloud"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.guice)
    implementation(libs.gson)
}

kotlin {
    jvmToolchain(21)
}

publishing {
    publications {
        create<MavenPublication>("api") {
            from(components["java"])
        }
    }
}