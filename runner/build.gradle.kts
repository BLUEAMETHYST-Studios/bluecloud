plugins {
    kotlin("jvm") version "1.9.22"
}

group = "me.blueamethyst.bluecloud"
version = project.property("project.version").toString()

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":api"))
    implementation(libs.kotlinxCoroutinesCore)
    implementation(libs.guice)
}

kotlin {
    jvmToolchain(21)
}