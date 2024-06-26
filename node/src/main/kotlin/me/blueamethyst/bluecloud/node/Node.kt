package me.blueamethyst.bluecloud.node

import me.blueamethyst.bluecloud.api.annontations.InternalBlueCloudApi
import me.blueamethyst.bluecloud.common.internal.AbstractSystemPart
import me.blueamethyst.bluecloud.common.internal.types.InternalSystemPartType
import me.blueamethyst.bluecloud.common.terminal.ConsoleColors
import me.blueamethyst.bluecloud.common.terminal.Logger
import me.blueamethyst.bluecloud.common.terminal.Terminal
import me.blueamethyst.bluecloud.common.terminal.cli.CLI
import me.blueamethyst.bluecloud.common.utils.LoggingUtils
import me.blueamethyst.bluecloud.node.commands.TemplatesCommand
import me.blueamethyst.bluecloud.node.injector.BlueCloudApiImpl
import me.blueamethyst.bluecloud.node.models.ClusterConfigModel
import me.blueamethyst.bluecloud.node.models.NodeConfigModel
import me.blueamethyst.bluecloud.node.models.SecretsModel
import me.blueamethyst.bluecloud.node.server.KtorApplication
import me.blueamethyst.bluecloud.node.utils.asciiArt
import me.blueamethyst.bluecloud.node.utils.generateRandomSecret
import me.blueamethyst.bluecloud.node.utils.json
import me.blueamethyst.bluecloud.node.utils.printInformationTable
import me.blueamethyst.bluecloud.wrapper.Wrapper
import java.io.File
import java.util.*
import kotlin.system.exitProcess

@InternalBlueCloudApi
class Node: AbstractSystemPart(InternalSystemPartType.NODE) {
    override val logger = LoggingUtils.getLogger("NODE", terminal.terminal)

    companion object {
        val terminal = Terminal()
        lateinit var logger: Logger
        lateinit var config: NodeConfigModel
        lateinit var cluster: ClusterConfigModel
        lateinit var cli: CLI
        internal lateinit var secrets: SecretsModel
    }

    override fun startup() {
        Companion.logger = logger
        initialize()
        postStart()
    }

    override fun shutdown() {
    }

    private fun initialize() {
        println(asciiArt())
        printInformationTable()
        provideInjector()
        setupFileStructure()
        provideConfigFile()
    }

    private fun postStart() {
        if (config.internalWrapperEnabled) provideWrapper()
        provideKtorServer()
        provideCli()
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
                            id = UUID.randomUUID().toString(),
                            name = terminal.terminal.prompt("What is the name of this node?", "Node-1", true) ?: exitProcess(-1),
                            internalWrapperEnabled = true,
                            otherNodes = terminal.terminal.prompt("What are the other nodes in the cluster? (seperate with ;)")?.split(";")?.map { it.trim() } ?: emptyList()
                        )
                    }
                )
            }
            directory("libraries")
            directory("modules")
            directory("local") {
                file<SecretsModel>("secrets.json", content = SecretsModel(generateRandomSecret(512)))
                directory("templates")
            }
        }
    }

    private fun provideConfigFile() {
        config = json.decodeFromString(
            File("node.json").readText(Charsets.UTF_8)
        )
        secrets = json.decodeFromString(
            File("local/secrets.json").readText(Charsets.UTF_8)
        )
        cluster = json.decodeFromString(
            File("cluster.json").readText(Charsets.UTF_8)
        )
    }

    // TODO
    private fun provideWrapper() {
        Wrapper().startup()
    }

    //TODO: only for testing purposes
    private fun provideKtorServer() {
        KtorApplication().start()
    }

    private fun provideInjector() {
        BlueCloudApiImpl()
    }

    private fun provideCli() {
        cli = CLI(
            logger,
            "${ConsoleColors.YELLOW_BRIGHT}CLI${ConsoleColors.BLACK_BRIGHT}@${ConsoleColors.BLUE_BRIGHT}BlueCloud ${ConsoleColors.BLACK_BRIGHT}» ${ConsoleColors.RESET}",
            listOf(TemplatesCommand())
        )
        cli.start()
    }

    private fun blockMainThread() {
        while (true) {
            Thread.sleep(50000)
        }
    }
}