package me.blueamethyst.bluecloud.wrapper.models

import kotlinx.serialization.Serializable

@Serializable
data class WrapperConfigModel(
    val maxMemory: Int,
    val serviceProcessType: String
)