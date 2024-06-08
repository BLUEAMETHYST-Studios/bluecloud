import me.blueamethyst.bluecloud.base.BlueCloudBase
import me.blueamethyst.bluecloud.base.template.CloudTemplateImpl
import me.blueamethyst.bluecloud.base.template.platform.PlatformDeployer
import me.blueamethyst.bluecloud.common.platforms.annontations.Platform
import me.blueamethyst.bluecloud.common.platforms.impl.server.PaperMCPlatform
import java.io.File

suspend fun main() {
    val base = BlueCloudBase()

    base.startup()
    base.templateDeploy.createTemplate(CloudTemplateImpl(
        "Test",
        "LOL",
        hashMapOf("Hallo" to "Welt")
    ))

    PlatformDeployer().deploy(File("test.jar"), PaperMCPlatform(), "1.20.4", "300")
}