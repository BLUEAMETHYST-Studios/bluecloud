package me.blueamethyst.bluecloud.runner.impl.screen

import me.blueamethyst.bluecloud.api.service.ICloudService
import me.blueamethyst.bluecloud.runner.AbstractServiceProcess
import me.blueamethyst.bluecloud.runner.annontations.OnlyOS
import me.blueamethyst.bluecloud.runner.types.OperatingSystem

@OnlyOS(OperatingSystem.LINUX)
class UnixScreenServiceProcess: AbstractServiceProcess() {
    lateinit var unixScreen: UnixScreen; private set
    lateinit var process: Process; private set

    override fun start(service: ICloudService, command: MutableList<String>) {
        unixScreen = UnixScreen("bluecloud-${service.getId()}", command)
        process = unixScreen.create().start()
    }

    override fun stop() {
        process.destroy()
    }

    override fun kill() {
        process.destroy()
    }
}