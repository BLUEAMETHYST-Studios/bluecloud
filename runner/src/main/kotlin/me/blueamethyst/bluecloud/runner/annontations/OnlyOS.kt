package me.blueamethyst.bluecloud.runner.annontations

import me.blueamethyst.bluecloud.runner.types.OperatingSystem

annotation class OnlyOS(
    val os: OperatingSystem
)