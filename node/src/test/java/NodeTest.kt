import me.blueamethyst.bluecloud.api.annontations.InternalBlueCloudApi
import me.blueamethyst.bluecloud.node.Node

@OptIn(InternalBlueCloudApi::class)
fun main() {
    Node().startup()
}