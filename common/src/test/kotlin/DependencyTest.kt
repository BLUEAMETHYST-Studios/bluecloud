import me.blueamethyst.bluecloud.common.dependency.DependencyImpl
import me.blueamethyst.bluecloud.common.dependency.DependencyLoaderImpl

val dependencyLoader = DependencyLoaderImpl()

fun main() {
    dependencyLoader.load(DependencyImpl("io.netty", "netty5-common", "5.0.0.Alpha5"))
}