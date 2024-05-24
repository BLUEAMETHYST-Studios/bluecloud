package me.blueamethyst.bluecloud.api.module

import me.blueamethyst.bluecloud.api.module.annontations.Module

abstract class AbstractModule {

    abstract fun load()
    abstract fun startup()
    abstract fun shutdown()

    fun getModuleInfo(): Module? {
        return this::class.java.getAnnotation(Module::class.java)
    }
}