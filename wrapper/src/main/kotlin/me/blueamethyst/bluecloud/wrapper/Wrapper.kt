package me.blueamethyst.bluecloud.wrapper

import me.blueamethyst.bluecloud.api.annontations.InternalBlueCloudApi
import me.blueamethyst.bluecloud.common.internal.AbstractSystemPart
import me.blueamethyst.bluecloud.common.internal.types.InternalSystemPartType
import me.blueamethyst.bluecloud.common.terminal.ConsoleColors
import me.blueamethyst.bluecloud.common.terminal.Logger
import me.blueamethyst.bluecloud.common.terminal.Terminal
import me.blueamethyst.bluecloud.common.utils.LoggingUtils
import me.blueamethyst.bluecloud.runner.AbstractServiceProcess
import me.blueamethyst.bluecloud.runner.ProcessRegistry
import me.blueamethyst.bluecloud.wrapper.logic.WrapperWatcher
import me.blueamethyst.bluecloud.wrapper.models.WrapperConfigModel
import me.blueamethyst.bluecloud.wrapper.utils.json
import me.blueamethyst.bluecloud.wrapper.utils.promptIntToValid
import java.io.File
import kotlin.reflect.KClass

class Wrapper: AbstractSystemPart(InternalSystemPartType.WRAPPER) {

    val terminal = Terminal()
    override val logger = LoggingUtils.getLogger("WRAPPER", terminal.terminal)

    companion object {
        lateinit var config: WrapperConfigModel
        lateinit var processType: KClass<out AbstractServiceProcess>
        lateinit var logger: Logger
        lateinit var terminal: Terminal
    }

    @InternalBlueCloudApi
    override fun startup() {
        Companion.terminal = terminal
        Companion.logger = logger

        initialize()
        postStart()
    }

    @InternalBlueCloudApi
    override fun shutdown() {
    }

    @InternalBlueCloudApi
    private fun initialize() {
        logger.info("Initializing Wrapper...")
        setupFileStructure()
        provideConfigFile()
        kotlin.runCatching {
            provideProcessType()
        }.onFailure {
            logger.error(it.stackTraceToString())
        }.onSuccess {
            logger.success("Found process type '${config.serviceProcessType}': ${ConsoleColors.YELLOW_BRIGHT}${processType.qualifiedName}")
        }
        logger.success("Wrapper initialized!")
    }

    @InternalBlueCloudApi
    private fun postStart() {
        logger.info("Starting Wrapper...")
        WrapperWatcher.instance.initialize()
        blockMainThread()
    }

    @InternalBlueCloudApi
    private fun setupFileStructure() {
        setupData {
            baseDirectory = "."

            directory("temp")
            directory("local") {
                file<WrapperConfigModel>(
                    name = "wrapper.json",
                    content = {
                        WrapperConfigModel(
                            maxMemory = promptIntToValid("How much memory should the wrapper use? (MB)"),
                            serviceProcessType = "jvm",
                            simultaneousServiceStartCount = 2
                        )
                    }
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

    private fun blockMainThread() {
        while (true) {
            Thread.sleep(50000)
        }
    }
}