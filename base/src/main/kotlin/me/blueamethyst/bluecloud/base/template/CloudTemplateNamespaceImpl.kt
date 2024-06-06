package me.blueamethyst.bluecloud.base.template

import kotlinx.serialization.Serializable
import me.blueamethyst.bluecloud.api.template.ICloudTemplate
import me.blueamethyst.bluecloud.api.template.ICloudTemplateNamespace

@Serializable
class CloudTemplateNamespaceImpl(
    private val name: String,
    private val templates: List<ICloudTemplate>
): ICloudTemplateNamespace {

    override fun getName(): String {
        return name
    }

    override fun getTemplates(): List<ICloudTemplate> {
        return templates
    }
}