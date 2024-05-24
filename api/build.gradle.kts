plugins {
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.serialization") version "1.9.24"
    `maven-publish`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.guice)
    implementation(libs.gson)
    implementation(libs.kotlinxSerializationJson)
    implementation(kotlin("reflect"))
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