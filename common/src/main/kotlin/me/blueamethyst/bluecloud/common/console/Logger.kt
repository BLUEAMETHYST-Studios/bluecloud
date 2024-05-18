package me.blueamethyst.bluecloud.common.console

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Logger(private val prefix: String, private val logWithTime: Boolean = false) {

    var printConsoleAfter: Boolean = false

    @Suppress("MemberVisibilityCanBePrivate")
    fun println(message: Any) {
        kotlin.io.println(message)
    }

    fun log(message: Any, subPrefix: String = "") {
        if (subPrefix != "")
            println("\r${preparePrefix()} $subPrefix - $message")
        else
            println("\r${preparePrefix()} $message")

        if (printConsoleAfter)
            console()
    }

    fun info(message: Any) {
        log(message, "${ConsoleColors.CYAN}INFO")
    }

    fun warning(message: Any) {
        log(message, "${ConsoleColors.YELLOW_BRIGHT}WARNING")
    }

    fun error(message: Any) {
        log(message, "${ConsoleColors.RED}ERROR")
    }

    fun success(message: Any) {
        log(message, "${ConsoleColors.GREEN}SUCCESS")
    }

    fun console() {
        print("\r${preparePrefix()} |> ")
    }

    private fun preparePrefix(): String {
        var localPrefix = this.prefix

        if (this.logWithTime)
            localPrefix = localPrefix.replace("%TIME%", getLogTime())

        return localPrefix
    }

    private fun getLogTime(): String {
        val dateTime = LocalDateTime.now()
        val dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")

        return dateTime.format(dateTimeFormatter)
    }

}