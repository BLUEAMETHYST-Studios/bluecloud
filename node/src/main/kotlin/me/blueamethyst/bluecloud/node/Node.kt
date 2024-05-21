package me.blueamethyst.bluecloud.node

import me.blueamethyst.bluecloud.common.internal.AbstractSystemPart
import me.blueamethyst.bluecloud.common.internal.types.InternalSystemPartType
import me.blueamethyst.bluecloud.common.terminal.Logger
import me.blueamethyst.bluecloud.common.terminal.Terminal
import me.blueamethyst.bluecloud.common.utils.LoggingUtils
import me.blueamethyst.bluecloud.node.models.NodeConfigModel

class Node: AbstractSystemPart(InternalSystemPartType.NODE) {
    val terminal = Terminal()
    override val logger = LoggingUtils.getLogger("NODE", terminal.terminal)

    companion object {
        lateinit var logger: Logger
    }

    override fun startup() {
        Companion.logger = logger
        initialize()
    }

    override fun shutdown() {
    }

    private fun initialize() {
        setupFileStructure()
    }

    private fun postStart() {

    }

    private fun setupFileStructure() {
        setupData {
            baseDirectory = "."

            directory(".") {
                file("cluster.json")
                file<NodeConfigModel>(
                    name = "node.json",
                    content = {
                        NodeConfigModel(
                            id = "",
                            name = "",
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
}