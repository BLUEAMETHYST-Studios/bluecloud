plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
}

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