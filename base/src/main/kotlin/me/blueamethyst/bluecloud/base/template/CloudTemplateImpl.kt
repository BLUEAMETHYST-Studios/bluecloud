package me.blueamethyst.bluecloud.base.template

import kotlinx.serialization.Serializable
import me.blueamethyst.bluecloud.api.template.ICloudTemplate
import me.blueamethyst.bluecloud.api.template.ICloudTemplateNamespace

@Serializable
class CloudTemplateImpl(
    private val name: String,
    private val parentNamespace: String,
    private val properties: HashMap<String, String>
): ICloudTemplate {

    override fun getName(): String {
        return name
    }

    override fun getParentNamespace(): ICloudTemplateNamespace {
        return CloudTemplateNamespaceImpl(parentNamespace, listOf(this)) //TODO: implement right way
    }

    override fun getProperties(): HashMap<String, String> {
        return properties
    }

    override fun getProperty(key: String): String? {
        return properties[key]
    }

    override fun setProperty(key: String, value: String) {
        // TODO: set
    }

    override fun isPulled(): Boolean {
        TODO("Not yet implemented")
    }
}