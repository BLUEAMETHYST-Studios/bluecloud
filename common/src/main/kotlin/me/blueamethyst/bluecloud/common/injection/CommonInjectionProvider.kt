package me.blueamethyst.bluecloud.common.injection

import com.google.inject.Injector
import me.blueamethyst.bluecloud.api.BlueCloudApi
import me.blueamethyst.bluecloud.common.injection.modules.UtilsModule

class CommonInjectionProvider(
    private val injector: Injector = BlueCloudApi.getInstance().getInjector()
) {

    fun provide() {
        injector.createChildInjector(
            UtilsModule()
        )
    }
}