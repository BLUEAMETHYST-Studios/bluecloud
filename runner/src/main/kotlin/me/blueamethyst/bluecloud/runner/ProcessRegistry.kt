package me.blueamethyst.bluecloud.runner

import me.blueamethyst.bluecloud.runner.impl.JvmServiceProcess
import me.blueamethyst.bluecloud.runner.impl.screen.UnixScreenServiceProcess
import kotlin.reflect.KClass

class ProcessRegistry {
    private val processes = mutableMapOf(
        "jvm" to JvmServiceProcess::class,
        "screen" to UnixScreenServiceProcess::class
    )

    fun registerServiceProcess(name: String, process: KClass<out AbstractServiceProcess>) {
        processes[name] = process
    }

    fun getServiceProcess(name: String): KClass<out AbstractServiceProcess>? {
        return processes[name]
    }

    fun getServiceProcesses(): Map<String, KClass<out AbstractServiceProcess>> {
        return processes
    }

    companion object {
        val instance = ProcessRegistry()
    }
}