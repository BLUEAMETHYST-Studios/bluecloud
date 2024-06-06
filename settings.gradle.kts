plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "bluecloud"

include("runner")
include("api")
include("common")
include("wrapper")
include("node")

namespace("common")

fun namespace(name: String, exclude: List<String> = listOf("build", "src")) {
    File("$name/").listFiles()
        ?.filter { !exclude.contains(it.name) && !it.isFile}
        ?.forEach {
            include(":${it.path.replace("/", ":")}")
        }
}