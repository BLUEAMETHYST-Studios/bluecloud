package me.blueamethyst.bluecloud.api.template

interface ICloudTemplateNamespace {

    fun getTemplates(): List<ICloudTemplate>
}