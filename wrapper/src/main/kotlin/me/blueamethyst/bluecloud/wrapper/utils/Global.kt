package me.blueamethyst.bluecloud.wrapper.utils

import kotlinx.serialization.json.Json

val json = Json {
    prettyPrint = true
    ignoreUnknownKeys = true
}