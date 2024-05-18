package me.blueamethyst.bluecloud.wrapper.logic

import me.blueamethyst.bluecloud.api.service.ICloudService

class WrapperServiceProcessor {

    fun startService(service: ICloudService) {

    }

    fun stopService(service: ICloudService) {

    }

    fun killService(service: ICloudService) {

    }

    fun startNextFromQueue() {
        val service = WrapperQueue.instance.queue.first()
        startService(service)
        WrapperQueue.instance.queue.remove(service)
    }

    companion object {
        val instance = WrapperServiceProcessor()
    }
}