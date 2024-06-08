package me.blueamethyst.bluecloud.common.dependency

import com.google.inject.AbstractModule
import me.blueamethyst.bluecloud.api.dependency.IDependencyLoader

class DependencyModule: AbstractModule() {

    override fun configure() {
        bind(IDependencyLoader::class.java).toInstance(DependencyLoaderImpl.instance)
    }
}