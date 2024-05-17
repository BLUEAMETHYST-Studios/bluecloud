package me.blueamethyst.bluecloud.common.platforms.providers.papermc

import io.ktor.client.call.*
import io.ktor.client.request.*
import me.blueamethyst.bluecloud.common.platforms.AbstractPlatform
import me.blueamethyst.bluecloud.common.platforms.httpClient
import me.blueamethyst.bluecloud.common.platforms.providers.papermc.objects.ProjectResponse
import me.blueamethyst.bluecloud.common.platforms.providers.papermc.objects.ProjectVersionsResponse
import java.net.URL

abstract class AbstractPaperMCPlatform: AbstractPlatform() {
    abstract val project: String

    override suspend fun getMcVersions(): List<String> {
        return httpClient.get("https://api.papermc.io/v2/projects/$project/").body<ProjectResponse>().versions
    }

    override suspend fun getBuilds(mcVersion: String): List<String> {
        return httpClient.get("https://api.papermc.io/v2/projects/$project/versions/$mcVersion").body<ProjectVersionsResponse>().builds.map { it.toString() }
    }

    override suspend fun getDownloadUrl(mcVersion: String, build: String): URL {
        return URL("https://api.papermc.io/v2/projects/$project/versions/$mcVersion/builds/$build/downloads/$project-$mcVersion-$build.jar")
    }
}