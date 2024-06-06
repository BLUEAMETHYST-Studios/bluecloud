package me.blueamethyst.bluecloud.base.template

import me.blueamethyst.bluecloud.api.template.ICloudLocalTemplateStorage
import me.blueamethyst.bluecloud.api.template.ICloudTemplateNamespace
import me.blueamethyst.bluecloud.base.utils.json
import java.io.File

class LocalTemplateFactory: ICloudLocalTemplateStorage {

    val namespaces = arrayListOf<ICloudTemplateNamespace>()

    fun initialize() {
        indexNewTemplateNamespaces()
    }

    override fun getTemplateNamespaces(): List<ICloudTemplateNamespace> {
        return namespaces
    }

    override fun getTemplateNamespace(name: String): ICloudTemplateNamespace? {
        return namespaces.firstOrNull {
            it.getName() == name
        }
    }

    override fun pullTemplate(): Boolean {
        TODO("Not yet implemented")
    }

    override fun pullTemplateOrThrow() {
        TODO("Not yet implemented")
    }

    private fun indexNewTemplateNamespaces() {
        val query = (templateFolder.listFiles() ?: return)
            .filter { !it.isFile }
            .filter { File(it, "namespace.json").exists() }
            .filter { !namespaces.contains(json.decodeFromString<CloudTemplateNamespaceImpl>(File(it, "template.json").readText())) }
            .map { json.decodeFromString<CloudTemplateNamespaceImpl>(File(it, "template.json").readText()) }
        namespaces.addAll(query)
    }

    companion object {
        val templateFolder = File("local/templates")
    }
}