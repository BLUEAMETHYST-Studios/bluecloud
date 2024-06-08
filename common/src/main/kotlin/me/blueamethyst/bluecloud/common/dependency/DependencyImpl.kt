package me.blueamethyst.bluecloud.common.dependency

import me.blueamethyst.bluecloud.api.dependency.AbstractDependency
import java.io.File

class DependencyImpl(
    override val groupId: String,
    override val artifactId: String,
    override val version: String,
    override val classifier: String = "",
    override val repository: String = "https://repo.maven.apache.org/maven2/"
) : AbstractDependency() {

    override fun cached(): Boolean {
        return File("dependencies/$artifactId-$version.jar").exists()
    }

    override fun loaded(): Boolean {
        TODO("Not yet implemented")
    }

    private fun download() {
    }
}