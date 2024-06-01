import com.github.ajalt.mordant.terminal.Terminal
import me.blueamethyst.bluecloud.common.terminal.prompts.IntPrompt

fun main() {
    val prompt = IntPrompt("Test", Terminal())

    val ask = prompt.ask()

    println(ask)
}