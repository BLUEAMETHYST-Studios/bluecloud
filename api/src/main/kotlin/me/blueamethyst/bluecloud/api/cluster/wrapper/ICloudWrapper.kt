package me.blueamethyst.bluecloud.api.cluster.wrapper

import me.blueamethyst.bluecloud.api.service.ICloudService

interface ICloudWrapper {
    fun getMaxMemory(): Int
    fun getUsedMemory(): Int
    fun getRunningServices(): List<ICloudService>
    fun getStaticServiceDirectories(): List<String>
}