plugins {
    alias(libs.plugins.jvm)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.clikt)
    implementation(libs.mordant)
    implementation(libs.mordantCoroutines)
}

kotlin {
    jvmToolchain(21)
}