package me.blueamethyst.bluecloud.wrapper.logic

import me.blueamethyst.bluecloud.wrapper.Wrapper.Companion.logger
import java.io.Closeable

class WrapperWatcher: Thread("wrapper-watcher"), Closeable {
    var running = false; private set

    init {
        isDaemon = true
    }

    fun initialize() {
        logger.info("Starting WrapperWatcher")
        running = true
        start()
    }

    private fun spin() {
        while (running) {
            //TODO: check if service is in the queue
            sleep(1000)
        }
    }

    override fun close() {
        running = false
        interrupt()
        logger.info("Closed WrapperWatcher")
    }

    companion object {
        val instance = WrapperWatcher()
    }

    override fun run() {
        spin()
    }
}