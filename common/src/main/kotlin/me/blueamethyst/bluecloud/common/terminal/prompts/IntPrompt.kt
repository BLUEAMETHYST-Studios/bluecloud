package me.blueamethyst.bluecloud.common.terminal.prompts

import com.github.ajalt.mordant.terminal.ConversionResult
import com.github.ajalt.mordant.terminal.Prompt
import com.github.ajalt.mordant.terminal.Terminal

class IntPrompt(
    prompt: String,
    terminal: Terminal,
    default: Int? = null,
    private val uppercaseDefault: Boolean = true,
    showChoices: Boolean = true,
    choices: Collection<Int> = emptySet(),
    private val choiceStrings: List<String> = listOf("y", "n"),
    promptSuffix: String = ": ",
    invalidChoiceMessage: String = "Invalid value, choose from ",
) : Prompt<Int>(
    prompt,
    terminal,
    default,
    false,
    showChoices,
    false,
    choices,
    promptSuffix,
    invalidChoiceMessage
) {
    override fun convert(input: String): ConversionResult<Int> {
        return try {
            ConversionResult.Valid(input.toInt())
        } catch (e: NumberFormatException) {
            ConversionResult.Invalid("Invalid number")
        }
    }
}