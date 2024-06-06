package me.blueamethyst.bluecloud.api.template

interface ICloudTemplate {
    fun getName(): String
    fun getParentNamespace(): ICloudTemplateNamespace
    fun getProperties(): HashMap<String, String>
    fun getProperty(key: String): String?
    fun setProperty(key: String, value: String)
    fun isPulled(): Boolean
}