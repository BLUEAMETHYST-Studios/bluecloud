package me.blueamethyst.bluecloud.base.template

import kotlinx.serialization.encodeToString
import me.blueamethyst.bluecloud.api.template.ICloudTemplate
import me.blueamethyst.bluecloud.base.BlueCloudBase
import me.blueamethyst.bluecloud.base.extension.serializable
import me.blueamethyst.bluecloud.base.utils.json
import java.io.File

class LocalTemplateDeploy {
    val templateFolder = LocalTemplateFactory.templateFolder

    fun createTemplate(template: ICloudTemplate) {
        BlueCloudBase.instance.logger.info("Creating template ${template.getName()}...")
        val serializable = template.serializable()
        val folder = File(templateFolder, "${serializable.getParentNamespace().getName()}/${serializable.getName()}")

        if (!folder.exists()) {
            folder.mkdirs()
        }

        File(folder, "template.json").apply {
            if (!exists()) createNewFile()
            writeText(json.encodeToString<CloudTemplateImpl>(serializable))
        }
        BlueCloudBase.instance.logger.success("Created template ${template.getName()}.")
    }
}