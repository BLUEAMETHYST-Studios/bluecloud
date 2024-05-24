package me.blueamethyst.bluecloud.runner.impl.screen

import me.blueamethyst.bluecloud.api.service.ICloudService
import me.blueamethyst.bluecloud.runner.AbstractServiceProcess
import me.blueamethyst.bluecloud.runner.annontations.OnlyOS
import me.blueamethyst.bluecloud.runner.exception.PlatformFileNotExistsException
import me.blueamethyst.bluecloud.runner.types.OperatingSystem
import java.io.File

@OnlyOS(OperatingSystem.LINUX)
class UnixScreenServiceProcess: AbstractServiceProcess() {
    lateinit var unixScreen: UnixScreen; private set
    lateinit var process: Process; private set
    lateinit var directory: File; private set
    lateinit var startCommand: MutableList<String>; private set

    override fun start(service: ICloudService, command: MutableList<String>) {
        unixScreen = UnixScreen("bluecloud-${service.getId()}", command)
        startCommand = command
        if (!directory.parentFile.exists()) directory.mkdirs()

        if (!File(directory, "platform.jar").exists()) {
            kill()
            throw PlatformFileNotExistsException()
        }

        createProcess()
    }

    override fun stop() {
        process.destroy()
    }

    override fun kill() {
        process.destroy()
    }

    private fun createProcess() {
        process = unixScreen.create()
            .directory(directory)
            .start()
    }
}