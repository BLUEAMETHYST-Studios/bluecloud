package me.blueamethyst.bluecloud.base.utils

import io.ktor.client.*
import io.ktor.client.plugins.*
import kotlinx.serialization.json.Json

internal val json = Json {
    prettyPrint = true
    ignoreUnknownKeys = true
}

val httpClient = HttpClient {
    install(HttpTimeout) {
        connectTimeoutMillis = 60000
    }
}
