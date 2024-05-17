package me.blueamethyst.bluecloud.common.injection.modules

import com.google.inject.AbstractModule
import com.google.inject.Provides
import kotlinx.coroutines.CoroutineScope
import me.blueamethyst.bluecloud.api.annontations.InternalCoroutineScope
import me.blueamethyst.bluecloud.common.utils.CoroutineUtils

class UtilsModule: AbstractModule() {

    @Provides
    @InternalCoroutineScope
    fun provideInternalCoroutineScope(): CoroutineScope {
        return CoroutineUtils.internalCoroutineScope
    }
}