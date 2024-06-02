plugins {
    alias(libs.plugins.jvm)
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.bundles.ktorClient)
    implementation(kotlin("reflect"))
}