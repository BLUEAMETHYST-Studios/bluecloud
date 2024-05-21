package me.blueamethyst.bluecloud.common.console.cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import me.blueamethyst.bluecloud.common.console.Logger
import me.blueamethyst.bluecloud.common.console.cli.command.RootCommand
import java.io.Closeable

class CLI(
    private val logger: Logger,
    private val prompt: String,
    val subCommands: List<CliktCommand>
): Thread("cli-thread"), Closeable {

    var running = false; private set

    init {
        isDaemon = true
    }

    override fun start() {
        running = true
        super.start()
    }

    override fun run() {
        while (running) {
            print(prompt)

            val input = readlnOrNull()

            if (input == null) {
                logger.error("Failed to read input")
                continue
            }

            if (input.isBlank()) {
                continue
            }
            RootCommand().subcommands(subCommands).main(input.split(" ").toTypedArray())
        }
    }

    override fun close() {
        running = false
    }
}