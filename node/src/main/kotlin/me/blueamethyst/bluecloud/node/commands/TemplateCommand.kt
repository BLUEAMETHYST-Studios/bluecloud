package me.blueamethyst.bluecloud.node.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.NoOpCliktCommand
import com.github.ajalt.clikt.core.subcommands
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.options.flag
import com.github.ajalt.clikt.parameters.options.option

class TemplateCommand: NoOpCliktCommand(name = "templates", help = "Manage Templates") {

    init {
        subcommands(Create(), Delete(), Pull(), List(), Info())
    }

    class Create: CliktCommand(name = "create", help = "Create a new Template") {
        private val templateName by argument("name", help = "Name of the new template")

        override fun run() {
            println("Creating template $templateName")
            //TODO
        }
    }
    class Delete: CliktCommand(name = "delete", help = "Delete a Template") {
        private val templateName by argument("name", help = "Name of the template to delete")
        private val global by option("-g", "--global", help = "Delete the template globally").flag()
        private val force by option("-f", "--force", help = "Force delete the template").flag()

        override fun run() {
            println("Deleting template $templateName with global=$global and force=$force")
            //TODO
        }
    }

    class Pull: CliktCommand(name = "pull", help = "Pull a Template") {
        private val templateName by argument("name", help = "Name of the template to pull")

        override fun run() {
            println("Pulling template $templateName")
            //TODO
        }
    }

    class List: CliktCommand(name = "list", help = "List all Templates") {
        override fun run() {
            println("Listing all templates")
            //TODO
        }
    }

    class Info: CliktCommand(name = "info", help = "Get info about a Template") {
        private val templateName by argument("name", help = "Name of the template to get info about")

        override fun run() {
            println("Getting info about template $templateName")
            //TODO
        }
    }
}