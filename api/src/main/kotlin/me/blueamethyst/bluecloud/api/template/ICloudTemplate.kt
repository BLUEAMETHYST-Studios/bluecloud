package me.blueamethyst.bluecloud.api.template

interface ICloudTemplate {
    fun getName()
    fun getProperties(): HashMap<String, String>
    fun getProperty(key: String): String?
    fun setProperty(key: String, value: String)
}