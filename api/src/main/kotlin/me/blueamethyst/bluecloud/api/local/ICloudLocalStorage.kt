package me.blueamethyst.bluecloud.api.local

import me.blueamethyst.bluecloud.api.template.ICloudTemplateNamespace

interface ICloudLocalStorage {

    fun getTemplateNamespaces(): List<ICloudTemplateNamespace>
}