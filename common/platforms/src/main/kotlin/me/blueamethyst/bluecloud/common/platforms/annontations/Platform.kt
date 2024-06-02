package me.blueamethyst.bluecloud.common.platforms.annontations

import me.blueamethyst.bluecloud.common.platforms.types.PlatformLanguage
import me.blueamethyst.bluecloud.common.platforms.types.PlatformType

annotation class Platform(
    val name: String,
    val type: PlatformType,
    val author: String = "Unknown",
    val forkOf: String = "Unknown",
    val website: String = "Unknown",
    val license: String = "Unknown",
    val sourceCode: String = "Unknown",
    val language: PlatformLanguage,
    val addonFolder: String
)
