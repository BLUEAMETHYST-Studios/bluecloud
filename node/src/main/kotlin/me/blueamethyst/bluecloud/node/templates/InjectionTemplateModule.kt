package me.blueamethyst.bluecloud.node.templates

import com.google.inject.AbstractModule
import me.blueamethyst.bluecloud.api.template.ICloudLocalTemplateStorage

class InjectionTemplateModule: AbstractModule() {

    override fun configure() {
        bind(ICloudLocalTemplateStorage::class.java).to(CloudLocalTemplateStorageImpl::class.java)
    }
}