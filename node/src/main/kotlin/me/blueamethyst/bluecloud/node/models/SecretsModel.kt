package me.blueamethyst.bluecloud.node.models

import kotlinx.serialization.Serializable

@Serializable
data class SecretsModel(
    val clusterSecret: String
)