plugins {
    kotlin("jvm") version "1.9.24"
    kotlin("plugin.serialization") version "1.9.24"
}

group = "me.blueamethyst.bluecloud"

repositories {
    mavenCentral()
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    implementation(project(":api"))
    implementation(project(":common"))
    implementation(project(":wrapper")) // TODO
    implementation(libs.kotlinxSerializationJson)
    implementation(libs.guice)
    implementation(libs.mordant)
    implementation(libs.mordantCoroutines)
    implementation(libs.osganNetty)
    implementation(kotlin("reflect"))
}

tasks.test {
    useJUnitPlatform()
}