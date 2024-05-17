package me.blueamethyst.bluecloud.wrapper

import me.blueamethyst.bluecloud.common.internal.AbstractSystemPart
import me.blueamethyst.bluecloud.common.internal.types.InternalSystemPartType
import me.blueamethyst.bluecloud.wrapper.models.WrapperConfigModel

class Wrapper: AbstractSystemPart(InternalSystemPartType.WRAPPER) {

    override fun startup() {
        setupFileStructure()
    }

    override fun shutdown() {
    }

    private fun setupFileStructure() {
        setupData {
            baseDirectory = "."

            directory("temp")
            directory("local") {
                file<WrapperConfigModel>(
                    name = "wrapper.json",
                    content = WrapperConfigModel(
                        maxMemory = 1024 // TODO: Prompt user for this value
                    )
                )
            }
        }
    }
}