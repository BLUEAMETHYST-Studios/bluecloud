package me.blueamethyst.bluecloud.common.platforms

import me.blueamethyst.bluecloud.common.platforms.annontations.Platform
import java.net.URL
import kotlin.reflect.full.findAnnotation

abstract class AbstractPlatform {
    abstract suspend fun getMcVersions(): List<String>
    abstract suspend fun getBuilds(mcVersion: String): List<String>
    abstract suspend fun getDownloadUrl(mcVersion: String, build: String): URL

    fun getPlatformInfo(): Platform? {
        return this::class.findAnnotation()
    }
}