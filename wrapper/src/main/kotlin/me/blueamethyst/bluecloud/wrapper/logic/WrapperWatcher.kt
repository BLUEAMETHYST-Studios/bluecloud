package me.blueamethyst.bluecloud.wrapper.logic

import me.blueamethyst.bluecloud.api.annontations.InternalBlueCloudApi
import me.blueamethyst.bluecloud.wrapper.Wrapper.Companion.logger
import java.io.Closeable
import me.blueamethyst.bluecloud.wrapper.logic.WrapperQueue as Queue
import me.blueamethyst.bluecloud.wrapper.logic.WrapperServiceProcessor as ServiceProcessor

@InternalBlueCloudApi
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
            if (Queue.instance.queue.isNotEmpty()) {
                val service = Queue.instance.queue.first()
                ServiceProcessor.instance.startService(service)
                Queue.instance.queue.remove(service) // TODO: implement simultaneousServiceStartCount
            }
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