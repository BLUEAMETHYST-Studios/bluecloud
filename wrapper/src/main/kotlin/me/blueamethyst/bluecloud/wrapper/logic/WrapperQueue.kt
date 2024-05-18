package me.blueamethyst.bluecloud.wrapper.logic

import me.blueamethyst.bluecloud.api.service.ICloudService

class WrapperQueue {
    internal val queue = arrayListOf<ICloudService>()

    companion object {
        val instance = WrapperQueue()
    }

    fun getQueue(): ArrayList<ICloudService> {
        return queue
    }

    fun addServiceToQueue(service: ICloudService) {
        queue.addLast(service)
    }

    fun removeServiceFromQueue(service: ICloudService) {
        queue.remove(service)
    }

    fun clearQueue() {
        queue.clear()
    }
}