import me.blueamethyst.bluecloud.runner.ServiceProcess
import java.io.File

fun main() {
    val service = ServiceProcess(File("./"), "help")

    service.start()
    service.getServiceDisplay().adaptOutAndResolveIn()
}