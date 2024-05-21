package me.blueamethyst.bluecloud.common.utils

object ResourceUtils {

    fun readResourceFile(fileName: String): String? {
        val resource = this.javaClass.getResourceAsStream("/$fileName")
        return resource?.bufferedReader()?.use { it.readText() }
    }
}