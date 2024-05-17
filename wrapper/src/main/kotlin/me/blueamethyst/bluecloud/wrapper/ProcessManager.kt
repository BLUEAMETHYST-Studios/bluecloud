package me.blueamethyst.bluecloud.wrapper

import me.blueamethyst.bluecloud.api.service.ICloudService
import me.blueamethyst.bluecloud.runner.ServiceProcess
import me.blueamethyst.bluecloud.wrapper.exception.StartFileNotFoundException
import java.io.File

class ProcessManager {

    val processMap = hashMapOf<ICloudService, ServiceProcess>()

    // TODO: static service check
    // TODO: copy template
    fun start(service: ICloudService) {
        val directory = File(generateProcessFolderName(service.getId()))

        if (!File(directory, "platform.jar").exists()) throw StartFileNotFoundException(service.getId())

        val process = ServiceProcess(
            directory = directory,
            javaCommand = "java",
            startFileName = "platform.jar"
        )
        processMap[service] = process
        process.start()
    }

    private fun generateProcessFolderName(id: String): String {
        return "temp/$id"
    }
}