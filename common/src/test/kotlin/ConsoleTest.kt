import com.github.ajalt.clikt.core.CliktCommand
import me.blueamethyst.bluecloud.common.console.ConsoleColors
import me.blueamethyst.bluecloud.common.console.Logger
import me.blueamethyst.bluecloud.common.console.cli.CLI

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