package me.blueamethyst.bluecloud.common.io

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

abstract class LocalFileCache(
    file: File,
    val json: Json = Json { ignoreUnknownKeys = true }
) {
    var cached: Boolean = false; private set
    var cachedObject: Any? = null
    val io = IO(file)

    inline fun <reified T> pull(default: T): T {
        if (io.create()) {
            cachedObject = default
            io.write(json.encodeToString<T>(default))
            return default
        }
        cachedObject = json.decodeFromString<T>(io.read())
        return cachedObject as T
    }

    inline fun <reified T> push() {
        io.write(json.encodeToString<T>(cachedObject as T))
    }

    inline fun <reified T> get(default: T): T {
        if (!cached) {
            cachedObject = pull(default)
        }
        return cachedObject as T
    }

    inline fun <reified T> set(value: T, push: Boolean = false) {
        cachedObject = value
        if (push) push<T>()
    }

    class IO(private val file: File) {

        fun create(): Boolean {
            return if (!file.exists()) {
                file.parentFile.mkdirs()
                file.createNewFile()
                true
            } else return false
        }

        fun read(): String {
            return file.readText()
        }

        fun write(content: String) {
            file.writeText(content)
        }
    }
}