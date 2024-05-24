package me.blueamethyst.bluecloud.api.module.models

import kotlinx.serialization.Serializable

@Serializable
data class ModuleConfiguration(
    val entrypoint: String
)
