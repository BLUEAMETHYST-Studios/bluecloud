plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.serialization)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":api"))
    implementation(libs.bundles.ktorClient)
    implementation(libs.guice)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}