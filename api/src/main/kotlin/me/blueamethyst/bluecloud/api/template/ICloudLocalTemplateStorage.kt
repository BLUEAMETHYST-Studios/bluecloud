package me.blueamethyst.bluecloud.api.template

interface ICloudLocalTemplateStorage {

    fun getTemplateNamespaces(): List<ICloudTemplateNamespace>
    fun getTemplateNamespace(name: String): ICloudTemplateNamespace?

    fun pullTemplate(): Boolean
    fun pullTemplateOrThrow()
}
