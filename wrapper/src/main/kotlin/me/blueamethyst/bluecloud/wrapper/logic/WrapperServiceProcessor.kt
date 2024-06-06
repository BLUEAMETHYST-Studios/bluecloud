package me.blueamethyst.bluecloud.wrapper.logic

import me.blueamethyst.bluecloud.api.annontations.InternalBlueCloudApi
import me.blueamethyst.bluecloud.api.service.ICloudService
import me.blueamethyst.bluecloud.wrapper.logic.abstraction.AbstractWrapperServiceProcessor

@InternalBlueCloudApi
class WrapperServiceProcessor: AbstractWrapperServiceProcessor() {
    private val runningServices = arrayListOf<ICloudService>()

    override fun startService(service: ICloudService) {

    }

    override fun stopService(service: ICloudService) {

    }

    override fun killService(service: ICloudService) {

    }

    override fun startNextFromQueue() {
        val service = WrapperQueue.instance.queue.firstOrNull()
        startService(service ?: return)
        WrapperQueue.instance.queue.remove(service)
    }

    override fun getRunningServices(): ArrayList<ICloudService> {
        return runningServices
    }

    companion object {
        val instance = WrapperServiceProcessor()
    }
}