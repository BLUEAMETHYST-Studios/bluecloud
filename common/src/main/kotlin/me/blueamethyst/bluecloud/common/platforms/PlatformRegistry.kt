package me.blueamethyst.bluecloud.common.platforms

import me.blueamethyst.bluecloud.common.platforms.impl.proxy.VelocityPlatform
import me.blueamethyst.bluecloud.common.platforms.impl.server.PaperMCPlatform
import me.blueamethyst.bluecloud.common.platforms.types.PlatformType

object PlatformRegistry {
    private val platforms = mutableListOf<AbstractPlatform>(
        // Proxies
        VelocityPlatform(),

        // Servers
        PaperMCPlatform()
    )

    fun register(platform: AbstractPlatform) {
        platforms.add(platform)
    }

    fun getPlatform(name: String): AbstractPlatform? {
        return platforms.find { it.getPlatformInfo()?.name == name }
    }

    fun getProxyPlatforms() = platforms.filter { (it.getPlatformInfo() ?: return listOf<AbstractPlatform>()).type == PlatformType.PROXY }.toList()
    fun getServers() = platforms.filter { (it.getPlatformInfo() ?: return listOf<AbstractPlatform>()).type == PlatformType.SERVER }.toList()

    fun getPlatforms() = platforms
}