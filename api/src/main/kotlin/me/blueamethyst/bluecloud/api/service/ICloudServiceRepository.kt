package me.blueamethyst.bluecloud.api.service

interface ICloudServiceRepository {
    fun getServices(): List<ICloudService>
    fun getServiceById(id: String): ICloudService?
    fun getServiceByName(name: String): ICloudService?
    fun registerService(service: ICloudService)
    fun unregisterService(service: ICloudService)
}