import BlueCloudDependencies.applyDependencies
import BlueCloudDependencies.blueCloud

val ktor_version: String by project

plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.serialization)
    alias(libs.plugins.shadow)
    BlueCloudDependencies
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":api"))
    implementation(project(":common"))
    implementation(project(":common:cli"))
    implementation(project(":wrapper")) // TODO
    blueCloud(implementation(libs.kotlinxSerializationJson))
    blueCloud(implementation(libs.guice))
    blueCloud(implementation(libs.mordant))
    blueCloud(implementation(libs.mordantCoroutines))
    blueCloud(implementation(libs.clikt))
    blueCloud(implementation(kotlin("reflect")))

    // Ktor
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-websockets-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-call-logging-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auth:$ktor_version")

    applyDependencies()
}

tasks.test {
    useJUnitPlatform()
}

tasks.shadowJar {
    archiveFileName = "node.jar"
    manifest {
        attributes(
            mapOf(
                "Main-Class" to "me.blueamethyst.bluecloud.node.BootKt",
            )
        )
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}