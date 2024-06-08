package me.blueamethyst.bluecloud.api.dependency

import java.nio.file.Path

interface IDependencyLoader {
    fun load(dependency: AbstractDependency)
    fun getDependencies(): List<AbstractDependency>
    fun addToClassPath(path: Path)
}