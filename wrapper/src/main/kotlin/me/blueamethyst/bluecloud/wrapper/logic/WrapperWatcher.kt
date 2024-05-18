package me.blueamethyst.bluecloud.wrapper.logic

import me.blueamethyst.bluecloud.wrapper.Wrapper.Companion.logger
import java.io.Closeable

class WrapperWatcher: Closeable {
    var running = false; private set

    fun start() {
        logger.info("Starting WrapperWatcher")
        running = true
        spin()
    }

    private fun spin() {
        while (running) {

        }
    }

    override fun close() {
        logger.info("Closed WrapperWatcher")
        running = false
    }

    companion object {
        val instance = WrapperWatcher()
    }
}