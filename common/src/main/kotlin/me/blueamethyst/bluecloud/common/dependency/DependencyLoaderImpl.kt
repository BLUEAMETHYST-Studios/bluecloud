package me.blueamethyst.bluecloud.common.dependency

import dev.httpmarco.osgan.files.OsganFile
import dev.httpmarco.osgan.files.OsganFileCreateOption
import me.blueamethyst.bluecloud.api.dependency.AbstractDependency
import me.blueamethyst.bluecloud.api.dependency.IDependencyLoader
import me.blueamethyst.bluecloud.common.classpath.CloudUrlClassLoader
import java.io.File
import java.nio.file.Path

class DependencyLoaderImpl: IDependencyLoader {

    val dependencyFolder = File("dependencies/")
    val loadedDependencies = arrayListOf<AbstractDependency>()

    override fun load(dependency: AbstractDependency) {
        this.download(dependency)
        this.addToClassPath(File(dependencyFolder, dependency.getFileName()).toPath())
    }

    override fun getDependencies(): List<AbstractDependency> {
        return loadedDependencies
    }

    override fun addToClassPath(path: Path) {
        //val classLoader = this.javaClass.classLoader as CloudUrlClassLoader
        CloudUrlClassLoader.instance.addURL(path.toUri().toURL())
    }

    private fun download(dependency: AbstractDependency) {
        val file = File(dependencyFolder, dependency.getFileName()).apply {
            if (exists()) return
        }
        val url = "$dependency${dependency.artifactId}-${dependency.version}${dependency.buildClassifier()}.jar"

        OsganFile(file.toPath(), OsganFileCreateOption.CREATION).download(url)
    }

    companion object {
        val instance = DependencyLoaderImpl()
    }
}