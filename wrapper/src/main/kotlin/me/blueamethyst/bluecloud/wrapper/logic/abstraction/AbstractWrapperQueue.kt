package me.blueamethyst.bluecloud.wrapper.logic.abstraction

import me.blueamethyst.bluecloud.api.service.ICloudService

abstract class AbstractWrapperQueue {
    abstract fun getQueue(): ArrayList<ICloudService>
    abstract fun addServiceToQueue(service: ICloudService)
    abstract fun removeServiceFromQueue(service: ICloudService)
    abstract fun clearQueue()
}