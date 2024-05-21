package me.blueamethyst.bluecloud.wrapper.utils

import com.github.ajalt.mordant.terminal.Terminal
import me.blueamethyst.bluecloud.common.terminal.prompts.IntPrompt
import me.blueamethyst.bluecloud.wrapper.Wrapper

fun promptIntToValid(prompt: String, terminal: Terminal = Wrapper.terminal.terminal): Int {
    var int: Int? = null

    while (int == null) {
        int = IntPrompt(prompt, terminal).ask()
    }

    return int
}