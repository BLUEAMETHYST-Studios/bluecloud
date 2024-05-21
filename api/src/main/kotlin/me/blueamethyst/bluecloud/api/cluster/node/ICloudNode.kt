package me.blueamethyst.bluecloud.api.cluster.node

import me.blueamethyst.bluecloud.api.cluster.wrapper.ICloudWrapper
import java.util.*

interface ICloudNode {
    fun getName(): String
    fun getId(): UUID
    fun getAddress(): String
    fun getInternalWrapper(): ICloudWrapper
    fun isHeadNode(): Boolean
    fun isFallbackHeadNode(): Boolean
    fun disconnect()
}