package me.blueamethyst.bluecloud.node.api.head

import com.google.inject.AbstractModule
import me.blueamethyst.bluecloud.api.cluster.ICloudCluster
import me.blueamethyst.bluecloud.node.api.head.cluster.HeadCloudClusterImpl

class HeadModule: AbstractModule() {

    override fun configure() {
        bind(ICloudCluster::class.java).to(HeadCloudClusterImpl::class.java)
    }
}