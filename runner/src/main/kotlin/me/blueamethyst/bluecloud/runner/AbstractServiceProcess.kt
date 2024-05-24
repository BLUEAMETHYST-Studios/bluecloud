package me.blueamethyst.bluecloud.runner

import me.blueamethyst.bluecloud.api.service.ICloudService

abstract class AbstractServiceProcess {

    abstract fun start(
        service: ICloudService,
        command: MutableList<String>
    )

    abstract fun stop()

    abstract fun kill()
}