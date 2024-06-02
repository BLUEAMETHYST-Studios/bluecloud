package me.blueamethyst.bluecloud.common.terminal.prompts

import com.github.ajalt.mordant.terminal.ConversionResult
import com.github.ajalt.mordant.terminal.Prompt
import com.github.ajalt.mordant.terminal.Terminal
import java.util.regex.Matcher
import java.util.regex.Pattern

class MemoryPrompt(
    prompt: String,
    terminal: Terminal,
    default: Int?,
    private val uppercaseDefault: Boolean = true,
    showChoices: Boolean = true,
    choices: Collection<Int> = emptySet(),
    private val choiceStrings: List<String> = listOf("1024M", "4G"),
    promptSuffix: String = ": ",
    invalidChoiceMessage: String = "Invalid value, choose from "
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

    val ends = listOf("M", "G")

    override fun convert(input: String): ConversionResult<Int> {
        var validEnd: String? = null

        if (input.isBlank()) {
            return ConversionResult.Invalid("empty input")
        }

        ends.forEach {
            if (it.endsWith(it)) {
                validEnd = it
            }
        }

        if (validEnd == null) {
            return ConversionResult.Invalid("invalid end")
        }

        val split = splitStringAndNumber(input) ?: return ConversionResult.Invalid("invalid")
        val final = calculate(split.second, split.first) ?: return ConversionResult.Invalid("invalid")

        return ConversionResult.Valid(final)
    }

    private fun calculate(suffix: String, value: Int): Int? {
        return when(suffix) {
            "M" -> value
            "G" -> value * 1024
            else -> null
        }
    }

    // https://stackoverflow.com/questions/3720012/regular-expression-to-split-string-and-number
    private fun splitStringAndNumber(string: String?): Pair<Int, String>? {
        val pattern = "(?<Numeric>[0-9]*)(?<Alpha>[a-zA-Z]*)"

        val p: Pattern = Pattern.compile(pattern)
        val m: Matcher = p.matcher(string)
        if (m.find()) {
            return Pair(m.group(1).toInt(), m.group(2).toString())
        }
        return null
    }
}