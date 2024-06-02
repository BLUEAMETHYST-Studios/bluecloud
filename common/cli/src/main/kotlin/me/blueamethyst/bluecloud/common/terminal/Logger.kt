package me.blueamethyst.bluecloud.common.terminal

import com.github.ajalt.mordant.rendering.TextColors.*
import com.github.ajalt.mordant.terminal.Terminal
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class Logger(
    private val prefix: String,
    private val logWithTime: Boolean = false,
    private val terminal: Terminal
) {

    var printConsoleAfter: Boolean = false

    @Suppress("MemberVisibilityCanBePrivate")
    fun println(message: Any) {
        terminal.println(message)
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
        log(message, cyan("INFO"))
    }

    fun warning(message: Any) {
        log(message, brightYellow("WARNING"))
    }

    fun error(message: Any) {
        log(message, red("ERROR"))
    }

    fun success(message: Any) {
        log(message, green("SUCCESS"))
    }

    private fun console() {
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