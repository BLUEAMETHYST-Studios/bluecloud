package me.blueamethyst.bluecloud.api.template

interface ICloudTemplateNamespace {
    fun getName(): String
    fun getTemplates(): List<ICloudTemplate>
}