package me.blueamethyst.bluecloud.runner

import me.blueamethyst.bluecloud.api.service.ICloudService

abstract class AbstractServiceProcess {

    abstract fun start(
        service: ICloudService,
        javaCommand: String = "java",
        jvmArguments: String = "",
        startFileName: String,
        processArguments: String = ""
    )

    abstract fun start(
        service: ICloudService,
        command: String
    )

    abstract fun stop()

    abstract fun kill()
}