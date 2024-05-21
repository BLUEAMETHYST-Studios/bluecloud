import com.github.ajalt.clikt.core.CliktCommand
import me.blueamethyst.bluecloud.common.terminal.ConsoleColors
import me.blueamethyst.bluecloud.common.terminal.Logger
import me.blueamethyst.bluecloud.common.terminal.cli.CLI

fun main() {
    val cli = CLI(
        Logger("Terminal", true),
        "${ConsoleColors.YELLOW_BRIGHT}CLI${ConsoleColors.BLACK_BRIGHT}@${ConsoleColors.BLUE_BRIGHT}BlueCloud ${ConsoleColors.BLACK_BRIGHT}» ${ConsoleColors.RESET}",
        listOf(
            MySubcommand()
        )
    )

    cli.start()

    while (true) {
        Thread.sleep(1000)
    }
}

class MySubcommand: CliktCommand(name = "subcommand") {

    override fun run() {
        println("Hello from subcommand!")
    }
}