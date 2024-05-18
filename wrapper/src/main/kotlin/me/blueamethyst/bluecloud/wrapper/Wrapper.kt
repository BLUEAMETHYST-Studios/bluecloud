package me.blueamethyst.bluecloud.wrapper

import me.blueamethyst.bluecloud.api.BlueCloudApi
import me.blueamethyst.bluecloud.common.console.ConsoleColors
import me.blueamethyst.bluecloud.common.internal.AbstractSystemPart
import me.blueamethyst.bluecloud.common.internal.types.InternalSystemPartType
import me.blueamethyst.bluecloud.runner.AbstractServiceProcess
import me.blueamethyst.bluecloud.runner.ProcessRegistry
import me.blueamethyst.bluecloud.wrapper.models.WrapperConfigModel
import me.blueamethyst.bluecloud.wrapper.utils.json
import java.io.File
import kotlin.reflect.KClass

class Wrapper: AbstractSystemPart(InternalSystemPartType.WRAPPER) {

    companion object {
        lateinit var config: WrapperConfigModel
        lateinit var processType: KClass<out AbstractServiceProcess>
    }

    override fun startup() {
        setupFileStructure()
        provideConfigFile()
        kotlin.runCatching {
            provideProcessType()
        }.onFailure {
            logger.error(it.stackTraceToString())
        }.onSuccess {
            logger.success("Found process type '${config.serviceProcessType}': ${ConsoleColors.YELLOW_BRIGHT}${processType.qualifiedName}")
        }
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
                        maxMemory = 1024, // TODO: Prompt user for this value
                        serviceProcessType = "jvm"
                    )
                )
            }
        }
    }

    private fun provideConfigFile() {
        config = json.decodeFromString(
            File("local/wrapper.json").readText(Charsets.UTF_8)
        )
    }

    private fun provideProcessType() {
        val serviceProcess = ProcessRegistry.instance.getServiceProcess(config.serviceProcessType)
            ?: throw IllegalStateException("Service process type '${config.serviceProcessType}' is not registered")

        processType = serviceProcess
    }
}