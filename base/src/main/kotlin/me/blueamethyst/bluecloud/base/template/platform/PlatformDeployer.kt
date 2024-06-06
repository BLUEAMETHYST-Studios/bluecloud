package me.blueamethyst.bluecloud.base.template.platform

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import me.blueamethyst.bluecloud.base.utils.httpClient
import me.blueamethyst.bluecloud.common.platforms.AbstractPlatform
import java.io.File

class PlatformDeployer {

    suspend fun deploy(destination: File, platform: AbstractPlatform, mcVersion: String, build: String) {
        destination.apply {
            if (!exists()) createNewFile()
        }

        val downloadUrl = platform.getDownloadUrl(mcVersion, build)
        val readBytes = httpClient.get(downloadUrl).body<HttpResponse>().readBytes()

        destination.writeBytes(readBytes)
    }
}