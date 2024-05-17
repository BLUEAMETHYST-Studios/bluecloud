package me.blueamethyst.bluecloud.runner

import java.io.File

class ServiceProcess {
    lateinit var process: Process; private set
    var directory: File; private set
    var startCommand: String; private set

    constructor(
        directory: File,
        javaCommand: String = "java",
        jvmArguments: String = "",
        startFileName: String,
        processArguments: String = ""
    ) {
        this.directory = directory
        this.startCommand = "$javaCommand $jvmArguments -jar $startFileName $processArguments"
    }

    constructor(
        directory: File,
        command: String
    ) {
        this.directory = directory
        this.startCommand = command
    }

    fun start() {
        process = ProcessBuilder(startCommand)
            .directory(directory)
            .start()
    }

    fun stop() {
    }

    fun kill() {
        process.destroy()
    }

    fun getServiceDisplay(): ServiceDisplay {
        return ServiceDisplay(process)
    }
}