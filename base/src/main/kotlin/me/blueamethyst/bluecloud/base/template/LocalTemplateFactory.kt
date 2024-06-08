package me.blueamethyst.bluecloud.base.template

import me.blueamethyst.bluecloud.api.template.ICloudLocalTemplateStorage
import me.blueamethyst.bluecloud.api.template.ICloudTemplateNamespace
import java.io.File

class LocalTemplateFactory: ICloudLocalTemplateStorage {

    val namespaces = arrayListOf<ICloudTemplateNamespace>()

    override fun getTemplateNamespaces(): List<ICloudTemplateNamespace> {
        return namespaces
    }

    override fun getTemplateNamespace(name: String): ICloudTemplateNamespace? {
        return namespaces.firstOrNull { it.getName() == name }
    }

    override fun pullTemplate(): Boolean {
        TODO("Not yet implemented")
    }

    override fun pullTemplateOrThrow() {
        TODO("Not yet implemented")
    }

    companion object {
        val templateFolder = File("local/templates")
    }
}