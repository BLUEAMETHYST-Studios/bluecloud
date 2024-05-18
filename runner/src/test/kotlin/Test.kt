import me.blueamethyst.bluecloud.api.service.ICloudService
import me.blueamethyst.bluecloud.runner.ProcessRegistry
import java.util.*

fun main() {
    val call = ProcessRegistry().getServiceProcess("jvm")!!.constructors.firstOrNull()!!.call()

    call.start(
        object : ICloudService {
            override fun getId(): String {
                return UUID.randomUUID().toString()
            }
        },
        command = "java"
    )
}