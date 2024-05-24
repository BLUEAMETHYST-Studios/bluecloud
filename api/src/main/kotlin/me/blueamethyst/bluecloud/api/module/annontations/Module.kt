package me.blueamethyst.bluecloud.api.module.annontations

annotation class Module(
    val name: String,
    val version: String,
    val description: String,
    val author: String,
    val dependencies: Array<String> = [],
    val reloadable: Boolean = false
)
