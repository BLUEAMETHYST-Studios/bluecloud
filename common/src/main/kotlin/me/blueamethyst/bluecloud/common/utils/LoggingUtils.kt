package me.blueamethyst.bluecloud.common.utils

import me.blueamethyst.bluecloud.common.console.ConsoleColors
import me.blueamethyst.bluecloud.common.console.Logger

object LoggingUtils {

    fun getLogger(usage: String): Logger {
        return Logger(
            "${ConsoleColors.BLACK_BRIGHT}[${ConsoleColors.CYAN_BOLD}Blue${ConsoleColors.WHITE_BOLD_BRIGHT}Cloud${ConsoleColors.BLACK_BRIGHT} - ${ConsoleColors.YELLOW_BRIGHT}$usage ${ConsoleColors.BLACK_BRIGHT}| ${ConsoleColors.CYAN_BRIGHT}%TIME%${ConsoleColors.BLACK_BRIGHT}]${ConsoleColors.RESET}",
            true
        )
    }
}