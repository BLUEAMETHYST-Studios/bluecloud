val ktor_version: String by project

plugins {
    kotlin("jvm") version "2.0.0"
    kotlin("plugin.serialization") version "2.0.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":api"))
    implementation(project(":common"))
    implementation(project(":wrapper")) // TODO
    implementation(libs.kotlinxSerializationJson)
    implementation(libs.guice)
    implementation(libs.mordant)
    implementation(libs.mordantCoroutines)
    implementation(libs.clikt)
    implementation(kotlin("reflect"))

    // Ktor
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-websockets-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-call-logging-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auth:$ktor_version")
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