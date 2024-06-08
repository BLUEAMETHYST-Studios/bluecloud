package me.blueamethyst.bluecloud.api.dependency

abstract class AbstractDependency {
    abstract val groupId: String
    abstract val artifactId: String
    abstract val version: String
    open val classifier: String = ""
    open val repository: String = "https://repo.maven.apache.org/maven2/"

    abstract fun cached(): Boolean
    abstract fun loaded(): Boolean

    open fun getFileName(): String {
        return "$artifactId-$version${buildClassifier()}.jar"
    }

    override fun toString(): String {
        return "$groupId:$artifactId:$version"
    }

    fun buildClassifier(): String {
        return if (classifier.isEmpty()) "" else "-$classifier"
    }
}