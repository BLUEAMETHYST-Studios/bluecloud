package me.blueamethyst.bluecloud.node.templates

import me.blueamethyst.bluecloud.api.template.ICloudLocalTemplateStorage
import me.blueamethyst.bluecloud.api.template.ICloudTemplateNamespace
import me.blueamethyst.bluecloud.common.io.LocalFileCache
import me.blueamethyst.bluecloud.node.templates.models.TemplateConfig
import java.io.File

class CloudLocalTemplateStorageImpl: ICloudLocalTemplateStorage {
    private val namespaces = mutableListOf<CloudTemplateNamespaceImpl>()

    private val default = TemplateConfig(
        namespaces
    )

    override fun getTemplateNamespaces(): List<ICloudTemplateNamespace> {
        if (namespaces.isEmpty()) query()
        return namespaces
    }

    override fun getTemplateNamespace(name: String): ICloudTemplateNamespace? {
        if (namespaces.isEmpty()) query()
        return namespaces.find { it.getName() == name }
    }

    override fun pullTemplate(): Boolean {
        TODO("Not yet implemented")
    }

    override fun pullTemplateOrThrow() {
        TODO("Not yet implemented")
    }

    private fun query() {
        namespaces.clear()
        namespaces.addAll(Cache.instance.get(default).namespaces)
    }

    private class Cache: LocalFileCache(
        file = File("local/templates.json"),
    ) {
        companion object {
            val instance = Cache()
        }
    }

    companion object {
        val instance: ICloudLocalTemplateStorage = CloudLocalTemplateStorageImpl()
    }
}