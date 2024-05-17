package me.blueamethyst.bluecloud.common.platforms.impl.proxy

import me.blueamethyst.bluecloud.common.platforms.annontations.Platform
import me.blueamethyst.bluecloud.common.platforms.providers.papermc.AbstractPaperMCPlatform
import me.blueamethyst.bluecloud.common.platforms.types.PlatformLanguage
import me.blueamethyst.bluecloud.common.platforms.types.PlatformType

@Platform(
    name = "Velocity",
    type = PlatformType.PROXY,
    author = "PaperMC Team",
    website = "https://papermc.io/",
    license = "https://github.com/PaperMC/Paper/blob/master/LICENSE.md",
    sourceCode = "https://github.com/PaperMC/Velocity",
    language = PlatformLanguage.JVM,
    addonFolder = "plugins"
)
class VelocityPlatform(override val project: String = "velocity") : AbstractPaperMCPlatform()