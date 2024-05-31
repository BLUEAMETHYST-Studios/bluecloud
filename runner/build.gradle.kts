plugins {
    kotlin("jvm") version "2.0.0"
}

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