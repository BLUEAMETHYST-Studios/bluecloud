plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "bluecloud"

include("runner")
include("api")
namespace("common")
include("wrapper")
include("node")
include("base")


fun namespace(name: String, exclude: List<String> = listOf("build", "src"), include: Boolean = true) {
    if (include) include(name)
    File("$name/").listFiles()
        ?.filter { !exclude.contains(it.name) && !it.isFile}
        ?.forEach {
            include(":${it.path.replace("/", ":")}")
        }
}
