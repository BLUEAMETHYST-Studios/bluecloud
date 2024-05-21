package me.blueamethyst.bluecloud.node.api.head.cluster

import me.blueamethyst.bluecloud.api.cluster.ICloudCluster
import me.blueamethyst.bluecloud.api.cluster.node.ICloudNode

class HeadCloudClusterImpl: ICloudCluster {
    val nodes = hashMapOf<String, ICloudNode>()

    override fun getNodes(): List<ICloudNode> {
        return nodes.values.toList()
    }

    override fun getHeadNode(): ICloudNode {
        TODO("Not yet implemented")
    }

    override fun getFallbackHeadNodes(): List<ICloudNode> {
        TODO("Not yet implemented")
    }

    override fun shutdownCleanly() {
        TODO("Not yet implemented")
    }

    override fun getNodeById(id: String): ICloudNode? {
        return nodes[id]
    }

    override fun getUsedMemory(): Long {
        TODO("Not yet implemented")
    }

    override fun getMaxMemory(): Long {
        TODO("Not yet implemented")
    }
}