package me.blueamethyst.bluecloud.node.models

import kotlinx.serialization.Serializable

@Serializable
data class NodeConfigModel(
    val id: String,
    val name: String,
    val internalWrapperEnabled: Boolean,
    val otherNodes: List<String>
)