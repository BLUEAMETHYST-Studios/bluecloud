plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.serialization)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":api"))
    implementation(project(":common"))
    implementation(project(":common:cli"))
    implementation(project(":runner"))
    implementation(libs.kotlinxSerializationJson)
    implementation(libs.guice)
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