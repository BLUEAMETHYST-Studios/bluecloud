package me.blueamethyst.bluecloud.runner.injection

import com.google.inject.AbstractModule
import me.blueamethyst.bluecloud.runner.ProcessRegistry

class ProcessRegistryModule: AbstractModule() {

    override fun configure() {
        bind(ProcessRegistry::class.java).toInstance(ProcessRegistry.instance)
    }
}