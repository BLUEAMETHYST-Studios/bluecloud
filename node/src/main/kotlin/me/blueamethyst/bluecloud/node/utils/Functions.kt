package me.blueamethyst.bluecloud.node.utils

import kotlin.random.Random

fun generateRandomSecret(length: Int): String {
    val allowedCharacters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz|!£$%&/=@#"
    val sb = StringBuilder(length)
    repeat(length) {
        sb.append(allowedCharacters[Random.nextInt(allowedCharacters.length)])
    }
    return sb.toString()
}