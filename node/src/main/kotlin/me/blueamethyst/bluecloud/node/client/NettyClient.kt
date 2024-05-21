package me.blueamethyst.bluecloud.node.client

import dev.httpmarco.osgan.networking.client.NettyClient
import dev.httpmarco.osgan.networking.client.NettyClientBuilder
import me.blueamethyst.bluecloud.api.annontations.InternalBlueCloudApi

@InternalBlueCloudApi
class NettyClient {
    lateinit var nettyClient: NettyClient

    fun startup() {
        nettyClient = NettyClientBuilder()
            .build()
    }
}