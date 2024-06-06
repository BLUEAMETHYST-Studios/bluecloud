package me.blueamethyst.bluecloud.wrapper.logic.abstraction

import me.blueamethyst.bluecloud.api.service.ICloudService

abstract class AbstractWrapperServiceProcessor {
    abstract fun startService(service: ICloudService)
    abstract fun stopService(service: ICloudService)
    abstract fun killService(service: ICloudService)
    abstract fun startNextFromQueue()
    abstract fun getRunningServices(): ArrayList<ICloudService>
}