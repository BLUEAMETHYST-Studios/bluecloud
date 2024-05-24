package me.blueamethyst.bluecloud.node.templates

import kotlinx.serialization.Serializable
import me.blueamethyst.bluecloud.api.template.ICloudTemplate
import me.blueamethyst.bluecloud.api.template.ICloudTemplateNamespace

@Serializable
class CloudTemplateNamespaceImpl(
    private val name: String,
    private val templates: List<CloudTemplateImpl>
): ICloudTemplateNamespace {

    override fun getName(): String {
        return name
    }

    override fun getTemplates(): List<ICloudTemplate> {
        return templates
    }
}