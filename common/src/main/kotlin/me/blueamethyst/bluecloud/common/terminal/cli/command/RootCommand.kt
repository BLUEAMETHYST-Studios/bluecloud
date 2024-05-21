package me.blueamethyst.bluecloud.common.terminal.cli.command

import com.github.ajalt.clikt.core.CliktCommand

class RootCommand: CliktCommand("root command of the cli", name = "cloud") {

    override fun run() = Unit
}