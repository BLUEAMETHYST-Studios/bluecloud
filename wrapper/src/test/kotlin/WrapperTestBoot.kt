import com.google.inject.Guice
import com.google.inject.Injector
import me.blueamethyst.bluecloud.api.BlueCloudApi
import me.blueamethyst.bluecloud.wrapper.Wrapper

fun main() {
    ApiImpl()
    Wrapper().startup()
}

class ApiImpl: BlueCloudApi() {
    private val injector = Guice.createInjector()

    override fun getInjector(): Injector {
        return injector
    }
}