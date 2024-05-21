package me.blueamethyst.bluecloud.node.models

import kotlinx.serialization.Serializable

@Serializable
data class ClusterConfigModel(
    val hostname: String,
    val port: Int
)
