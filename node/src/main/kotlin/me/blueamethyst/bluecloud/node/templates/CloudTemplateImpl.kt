package me.blueamethyst.bluecloud.node.templates

import kotlinx.serialization.Serializable
import me.blueamethyst.bluecloud.api.template.ICloudTemplate
import me.blueamethyst.bluecloud.api.template.ICloudTemplateNamespace

@Serializable
class CloudTemplateImpl(
    private val name: String,
    private val properties: HashMap<String, String>
): ICloudTemplate {

    override fun getName(): String {
        return name
    }

    override fun getParentNamespace(): ICloudTemplateNamespace {
        TODO("Not yet implemented")
    }

    override fun getProperties(): HashMap<String, String> {
        return properties
    }

    override fun getProperty(key: String): String? {
        return properties[key]
    }

    override fun setProperty(key: String, value: String) {
        TODO("Not yet implemented")
    }

    override fun isPulled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun toString(): String {
        return "$name:${getParentNamespace()?.getName() ?: "unknown"}"
    }
}