package me.blueamethyst.bluecloud.common.internal

import kotlinx.serialization.encodeToString
import me.blueamethyst.bluecloud.common.utils.SerializationUtils.json
import java.io.File

class FileManager(var baseDirectory: String = "") {

    val pathRegistry: HashMap<String, String> = hashMapOf()

    fun directory(name: String, registryName: String = name, directoryStructure: DirectoryStructure.() -> Unit = {}) {
        val folder = File(baseDirectory, name)
        folder.mkdirs()
        DirectoryStructure(this, folder).apply(directoryStructure)

        this.pathRegistry[registryName] = folder.path
    }

    fun file(name: String, registryName: String = name, excludeFromRegistry: Boolean = false) {
        val file = File(baseDirectory, name)

        if(!excludeFromRegistry)
            this.pathRegistry[registryName] = file.path

        if(file.exists())
            return

        file.parentFile.mkdirs()
        file.createNewFile()
    }

    inline fun <reified T> file(name: String, content: T, registryName: String = name, excludeFromRegistry: Boolean = false) {
        val file = File(baseDirectory, name)

        if(!excludeFromRegistry)
            this.pathRegistry[registryName] = file.path

        if(file.exists())
            return

        file.parentFile.mkdirs()
        file.createNewFile()

        file.writeText(json.encodeToString<T>(content))
    }

    inner class DirectoryStructure(val fileManager: FileManager, val parentDirectory: File) {
        fun directory(name: String, registryName: String = name, directoryStructure: DirectoryStructure.() -> Unit = {}) {
            val folder = File(parentDirectory, name)
            folder.mkdirs()

            fileManager.pathRegistry[registryName] = folder.path

            DirectoryStructure(fileManager, folder).apply(directoryStructure)
        }

        fun file(name: String, registryName: String = name, excludeFromRegistry: Boolean = false) {
            val file = File(parentDirectory, name)

            if(!excludeFromRegistry)
                fileManager.pathRegistry[registryName] = file.path

            if(file.exists())
                return

            file.parentFile.mkdirs()
            file.createNewFile()
        }

        inline fun <reified T> file(name: String, content: () -> T, registryName: String = name, excludeFromRegistry: Boolean = false) {
            val file = File(parentDirectory, name)

            if(!excludeFromRegistry)
                fileManager.pathRegistry[registryName] = file.path

            if(file.exists())
                return

            file.parentFile.mkdirs()
            file.createNewFile()


            file.writeText(json.encodeToString<T>(content.invoke()))
        }

        inline fun <reified T> file(name: String, content: T, registryName: String = name, excludeFromRegistry: Boolean = false) {
            val file = File(parentDirectory, name)

            if(!excludeFromRegistry)
                fileManager.pathRegistry[registryName] = file.path

            if(file.exists())
                return

            file.parentFile.mkdirs()
            file.createNewFile()


            file.writeText(json.encodeToString<T>(content))
        }
    }

}