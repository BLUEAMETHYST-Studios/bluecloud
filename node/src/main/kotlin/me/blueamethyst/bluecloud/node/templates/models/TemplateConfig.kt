package me.blueamethyst.bluecloud.node.templates.models

import kotlinx.serialization.Serializable
import me.blueamethyst.bluecloud.node.templates.CloudTemplateNamespaceImpl

@Serializable
data class TemplateConfig(
    val namespaces: List<CloudTemplateNamespaceImpl>
)