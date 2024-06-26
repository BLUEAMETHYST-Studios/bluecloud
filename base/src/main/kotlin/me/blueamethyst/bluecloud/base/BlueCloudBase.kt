package me.blueamethyst.bluecloud.base

import com.github.ajalt.mordant.terminal.Terminal
import me.blueamethyst.bluecloud.base.inject.BaseInjection
import me.blueamethyst.bluecloud.common.internal.AbstractSystemPart
import me.blueamethyst.bluecloud.common.internal.types.InternalSystemPartType
import me.blueamethyst.bluecloud.common.utils.LoggingUtils

class BlueCloudBase: AbstractSystemPart(InternalSystemPartType.BASE) {
    val injection = BaseInjection()

    override val logger = LoggingUtils.getLogger("BASE", Terminal())

    override fun startup() {
        setupFileStructure()
    }

    override fun shutdown() {
    }

    private fun setupFileStructure() {
        setupData {
            baseDirectory = "."

            directory("local") {
                directory("templates")
            }
        }
    }

    companion object {
        val instance = BlueCloudBase()
    }
}