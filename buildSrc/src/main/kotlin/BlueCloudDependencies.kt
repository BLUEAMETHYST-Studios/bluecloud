import kotlinx.serialization.json.Json
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

object BlueCloudDependencies {
    private val dependencies = arrayListOf<Dependency>()

    private val json = Json {
        prettyPrint = true
    }

    fun DependencyHandler.blueCloud(dependency: Dependency?) {
        dependencies.add(dependency ?: return)
    }

    fun DependencyHandler.applyDependencies() {
        var compiledList = "°NEXT°"

        dependencies.forEach {
            val compiled = "${it.group};${it.name};${it.version}"
            compiledList += "$compiled°NEXT°"
        }

        println(compiledList)
    }
}