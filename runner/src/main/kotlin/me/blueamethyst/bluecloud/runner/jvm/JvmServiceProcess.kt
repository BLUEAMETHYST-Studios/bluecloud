package me.blueamethyst.bluecloud.runner.jvm

import me.blueamethyst.bluecloud.api.service.ICloudService
import me.blueamethyst.bluecloud.runner.AbstractServiceProcess
import me.blueamethyst.bluecloud.runner.utils.ServiceDisplay
import java.io.File

class JvmServiceProcess: AbstractServiceProcess() {

    lateinit var process: Process; private set
    lateinit var directory: File; private set
    lateinit var startCommand: String; private set

    /*
    override fun start(
        service: ICloudService,
        javaCommand: String,
        jvmArguments: String,
        startFileName: String,
        processArguments: String
    ) {
        startCommand = "$javaCommand $jvmArguments -jar $startFileName $processArguments"
        createProcess()
    }
     */

    override fun start(service: ICloudService, command: String) {
        startCommand = command
        createProcess()
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    override fun kill() {
        process.destroy()
    }

    private fun createProcess() {
        process = ProcessBuilder(startCommand)
            .start()
    }

    fun getServiceDisplay(): ServiceDisplay {
        return ServiceDisplay(process)
    }
}