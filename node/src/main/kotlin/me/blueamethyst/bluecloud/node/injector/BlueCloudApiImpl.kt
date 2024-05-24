package me.blueamethyst.bluecloud.node.injector

import com.google.inject.Guice
import com.google.inject.Injector
import me.blueamethyst.bluecloud.api.BlueCloudApi
import me.blueamethyst.bluecloud.node.api.head.HeadModule
import me.blueamethyst.bluecloud.node.templates.InjectionTemplateModule

class BlueCloudApiImpl: BlueCloudApi() {

    internal companion object {
        val injector = Guice.createInjector(
            HeadModule(),
            InjectionTemplateModule()
        ) // TODO: remove HeadModule
    }

    override fun getInjector(): Injector {
        return injector
    }
}