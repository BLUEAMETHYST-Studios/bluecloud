package me.blueamethyst.bluecloud.wrapper.logic

import me.blueamethyst.bluecloud.api.annontations.InternalBlueCloudApi
import me.blueamethyst.bluecloud.api.service.ICloudService
import me.blueamethyst.bluecloud.wrapper.logic.abstraction.AbstractWrapperQueue

@InternalBlueCloudApi
class WrapperQueue: AbstractWrapperQueue() {
    internal val queue = arrayListOf<ICloudService>()

    override fun getQueue(): ArrayList<ICloudService> {
        return queue
    }

    override fun addServiceToQueue(service: ICloudService) {
        queue.addLast(service)
    }

    override fun removeServiceFromQueue(service: ICloudService) {
        queue.remove(service)
    }

    override fun clearQueue() {
        queue.clear()
    }

    companion object {
        val instance = WrapperQueue()
    }
}