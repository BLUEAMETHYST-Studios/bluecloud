allprojects {
    group = "me.blueamethyst.bluecloud"
    version = project.property("project.version").toString()

    repositories {
        mavenCentral()
        maven("https://s01.oss.sonatype.org/content/repositories/snapshots/")
    }
}