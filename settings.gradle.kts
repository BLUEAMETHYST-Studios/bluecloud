plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

rootProject.name = "bluecloud"

include("runner")
include("api")
include("common")
include("wrapper")
include("node")

val commonModulesExclude = listOf("build", "src")

File("common/").listFiles()
    ?.filter { !commonModulesExclude.contains(it.name) && !it.isFile}
    ?.forEach {
        include(":${it.path.replace("/", ":")}")
    }