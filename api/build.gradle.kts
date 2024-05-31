plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
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