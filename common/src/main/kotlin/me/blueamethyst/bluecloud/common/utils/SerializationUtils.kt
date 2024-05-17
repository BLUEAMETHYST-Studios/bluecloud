package me.blueamethyst.bluecloud.common.utils

import kotlinx.serialization.json.Json

object SerializationUtils {

    val json = Json {
        prettyPrint = true
    }
}