package me.blueamethyst.bluecloud.api.cluster

import me.blueamethyst.bluecloud.api.cluster.node.ICloudNode

interface ICloudCluster {
    fun getNodes(): List<ICloudNode>
    fun getHeadNode(): ICloudNode
    fun getFallbackHeadNodes(): List<ICloudNode>
    fun shutdownCleanly()

    fun getNodeById(id: String): ICloudNode?
    fun getUsedMemory(): Long
    fun getMaxMemory(): Long
}