plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.serialization)
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