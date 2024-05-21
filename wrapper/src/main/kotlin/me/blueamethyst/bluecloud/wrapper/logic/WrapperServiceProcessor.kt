package me.blueamethyst.bluecloud.wrapper.logic

import me.blueamethyst.bluecloud.api.annontations.InternalBlueCloudApi
import me.blueamethyst.bluecloud.api.service.ICloudService

@InternalBlueCloudApi
class WrapperServiceProcessor {
    private val runningServices = arrayListOf<ICloudService>()

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

    fun getRunningServices(): ArrayList<ICloudService> {
        return runningServices
    }

    companion object {
        val instance = WrapperServiceProcessor()
    }
}