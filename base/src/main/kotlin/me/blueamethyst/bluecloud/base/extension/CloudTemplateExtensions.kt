package me.blueamethyst.bluecloud.base.extension

import me.blueamethyst.bluecloud.api.template.ICloudTemplate
import me.blueamethyst.bluecloud.base.template.CloudTemplateImpl

fun ICloudTemplate.serializable(): CloudTemplateImpl {
    return CloudTemplateImpl(
        name = getName(),
        parentNamespace = getParentNamespace().getName(),
        properties = getProperties()
    )
}