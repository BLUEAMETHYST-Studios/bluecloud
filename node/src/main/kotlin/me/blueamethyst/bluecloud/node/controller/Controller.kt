package me.blueamethyst.bluecloud.node.controller

import dev.httpmarco.osgan.networking.server.NettyServer
import dev.httpmarco.osgan.networking.server.NettyServerBuilder
import me.blueamethyst.bluecloud.api.annontations.InternalBlueCloudApi
import me.blueamethyst.bluecloud.node.Node

@InternalBlueCloudApi
class Controller {
    lateinit var nettyServer: NettyServer

    fun startup() {
        nettyServer = NettyServerBuilder()
            .withHostname(Node.clusterConfig.hostname)
            .withPort(Node.clusterConfig.port)
            .build()
    }
}