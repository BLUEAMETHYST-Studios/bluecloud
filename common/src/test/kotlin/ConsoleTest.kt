import com.github.ajalt.clikt.core.CliktCommand
import me.blueamethyst.bluecloud.common.console.ConsoleColors
import me.blueamethyst.bluecloud.common.console.Logger
import me.blueamethyst.bluecloud.common.console.cli.Terminal
import java.net.InetAddress

fun main() {
    val terminal = Terminal(
        Logger("Terminal", true),
        "${ConsoleColors.YELLOW_BRIGHT}CLI${ConsoleColors.BLACK_BRIGHT}@${ConsoleColors.BLUE_BRIGHT}BlueCloud ${ConsoleColors.BLACK_BRIGHT}» ${ConsoleColors.RESET}",
        listOf(
            MySubcommand()
        )
    )

    terminal.start()

    while (true) {
        Thread.sleep(1000)
    }
}

class MySubcommand: CliktCommand(name = "subcommand") {

    override fun run() {
        println("Hello from subcommand!")
    }
}