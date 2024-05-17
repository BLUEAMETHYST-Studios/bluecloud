package me.blueamethyst.bluecloud.common.platforms.impl.server

import me.blueamethyst.bluecloud.common.platforms.annontations.Platform
import me.blueamethyst.bluecloud.common.platforms.providers.papermc.AbstractPaperMCPlatform
import me.blueamethyst.bluecloud.common.platforms.types.PlatformLanguage
import me.blueamethyst.bluecloud.common.platforms.types.PlatformType

@Platform(
    name = "PaperMC",
    type = PlatformType.SERVER,
    author = "PaperMC Team",
    forkOf = "Spigot",
    website = "https://papermc.io/",
    license = "https://github.com/PaperMC/Paper/blob/master/LICENSE.md",
    sourceCode = "https://github.com/PaperMC/paper",
    language = PlatformLanguage.JVM,
    addonFolder = "plugins"
)
class PaperMCPlatform(override val project: String = "paper") : AbstractPaperMCPlatform()