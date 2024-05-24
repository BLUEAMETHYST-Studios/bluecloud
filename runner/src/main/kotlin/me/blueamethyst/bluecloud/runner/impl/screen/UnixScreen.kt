package me.blueamethyst.bluecloud.runner.impl.screen

import java.nio.file.Path

class UnixScreen(
    val name: String,
    val command: MutableList<String>,
) {

    fun create(): ProcessBuilder {
        return ProcessBuilder(buildCommand())
    }

    private fun buildCommand(): MutableList<String> {
        return buildList {
            add("screen")
            add("-dmS")
            add(name)
            addAll(command)
        }.toMutableList()
    }
}