plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.serialization)
}

repositories {
    mavenCentral()
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
}

dependencies {
    implementation(project(":api"))
    implementation(project(":common:cli"))
    implementation(project(":common:platforms"))
    implementation(libs.bundles.ktorClient)
    implementation(libs.guice)
    implementation(libs.mordant)
    implementation(libs.bundles.osgan)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}