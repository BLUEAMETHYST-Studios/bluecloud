package me.blueamethyst.bluecloud.base.utils

import kotlinx.serialization.json.Json

internal val json = Json {
    prettyPrint = true
    ignoreUnknownKeys = true
}