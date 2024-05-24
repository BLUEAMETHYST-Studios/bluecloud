package me.blueamethyst.bluecloud.runner.types

enum class OperatingSystem {
    WINDOWS,
    LINUX,
    MACOS,
    UNKNOWN;

    companion object {
        val current = System.getProperty("os.name").lowercase().let { osName ->
            entries.singleOrNull { osName.startsWith(it.toString().lowercase()) } ?: UNKNOWN
        }
    }
}