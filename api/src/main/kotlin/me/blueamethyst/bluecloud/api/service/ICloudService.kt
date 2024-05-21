package me.blueamethyst.bluecloud.api.service

import me.blueamethyst.bluecloud.api.cluster.node.ICloudNode
import me.blueamethyst.bluecloud.api.template.ICloudTemplate

interface ICloudService {

    fun getDisplayName(): String
    fun getId(): String
    fun isStatic(): Boolean
    fun getTemplates(): List<ICloudTemplate>
    fun getNode(): ICloudNode
    fun getAddress(): String
    fun getPort(): Int
    fun getMemory(): Int
    fun getJvmArguments(): List<String>
    fun getProcessArguments(): List<String>
}