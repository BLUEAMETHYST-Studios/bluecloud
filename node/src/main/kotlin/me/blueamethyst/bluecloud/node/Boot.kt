package me.blueamethyst.bluecloud.node

import me.blueamethyst.bluecloud.api.annontations.InternalBlueCloudApi

@OptIn(InternalBlueCloudApi::class)
fun main() {
    Node().startup()
}