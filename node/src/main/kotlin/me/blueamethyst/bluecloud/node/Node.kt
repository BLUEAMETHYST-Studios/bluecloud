package me.blueamethyst.bluecloud.node

import me.blueamethyst.bluecloud.api.annontations.InternalBlueCloudApi
import me.blueamethyst.bluecloud.common.internal.AbstractSystemPart
import me.blueamethyst.bluecloud.common.internal.types.InternalSystemPartType
import me.blueamethyst.bluecloud.common.terminal.Logger
import me.blueamethyst.bluecloud.common.terminal.Terminal
import me.blueamethyst.bluecloud.common.utils.LoggingUtils
import me.blueamethyst.bluecloud.node.models.ClusterConfigModel
import me.blueamethyst.bluecloud.node.models.NodeConfigModel
import me.blueamethyst.bluecloud.node.utils.json
import me.blueamethyst.bluecloud.wrapper.Wrapper
import java.io.File

@InternalBlueCloudApi
class Node: AbstractSystemPart(InternalSystemPartType.NODE) {
    val terminal = Terminal()
    override val logger = LoggingUtils.getLogger("NODE", terminal.terminal)

    companion object {
        lateinit var logger: Logger
        lateinit var config: NodeConfigModel
        lateinit var clusterConfig: ClusterConfigModel
    }

    override fun startup() {
        Companion.logger = logger
        initialize()
        postStart()
    }

    override fun shutdown() {
    }

    private fun initialize() {
        setupFileStructure()
        provideConfigFile()
    }

    private fun postStart() {
        if (config.internalWrapperEnabled) provideWrapper()
        blockMainThread()
    }

    private fun setupFileStructure() {
        setupData {
            baseDirectory = "."

            directory(".") {
                file<ClusterConfigModel>(
                    name = "cluster.json",
                    content = {
                        ClusterConfigModel(
                            hostname = "127.0.0.1",
                            port = 33333
                        )
                    })
                file<NodeConfigModel>(
                    name = "node.json",
                    content = {
                        NodeConfigModel(
                            id = "",
                            name = "",
                            internalWrapperEnabled = true,
                            otherNodes = emptyList()
                        )
                    }
                )
            }
            directory("libraries")
            directory("modules")
            directory("local") {
                directory("templates")
            }
        }
    }

    private fun provideConfigFile() {
        config = json.decodeFromString(
            File("node.json").readText(Charsets.UTF_8)
        )
        clusterConfig = json.decodeFromString(
            File("cluster.json").readText(Charsets.UTF_8)
        )
    }

    // TODO
    private fun provideWrapper() {
        Wrapper().startup()
    }

    private fun blockMainThread() {
        while (true) {
            Thread.sleep(50000)
        }
    }
}