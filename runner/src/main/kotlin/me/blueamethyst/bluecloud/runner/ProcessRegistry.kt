package me.blueamethyst.bluecloud.runner

import me.blueamethyst.bluecloud.runner.impl.JvmServiceProcess
import kotlin.reflect.KClass

class ProcessRegistry {
    private val processes = mutableMapOf<String, KClass<out AbstractServiceProcess>>(
        "jvm" to JvmServiceProcess::class,
        "screen" to JvmServiceProcess::class
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