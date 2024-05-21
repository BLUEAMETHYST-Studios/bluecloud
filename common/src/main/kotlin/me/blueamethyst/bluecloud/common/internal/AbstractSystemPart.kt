package me.blueamethyst.bluecloud.common.internal

import me.blueamethyst.bluecloud.common.internal.types.InternalSystemPartType
import me.blueamethyst.bluecloud.common.terminal.Logger
import me.blueamethyst.bluecloud.common.utils.SerializationUtils.json
import java.io.File
import java.io.FileNotFoundException

abstract class AbstractSystemPart(type: InternalSystemPartType) {
    lateinit var fileManager: FileManager
    abstract val logger: Logger

    fun setupData(fileManagerBuilder: FileManager.() -> Unit) {
        logger.log("Starting data setup...")
        fileManager = FileManager().apply(fileManagerBuilder)
        logger.success("Finished data setup!")
    }

    fun requireSetupFile(name: String) {
        if (!File(name).exists())
            throw FileNotFoundException("Cannot find the setup file '$name'!")
    }

    inline fun <reified T> loadSetupFile(name: String): T? {
        val setupFile = File(name)

        if(!setupFile.exists())
            return null

        return json.decodeFromString<T>(setupFile.readText())
    }


    abstract fun startup()
    abstract fun shutdown()
}