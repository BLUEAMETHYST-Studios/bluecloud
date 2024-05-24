package me.blueamethyst.bluecloud.node.utils

import com.github.ajalt.mordant.table.table
import me.blueamethyst.bluecloud.api.annontations.InternalBlueCloudApi
import me.blueamethyst.bluecloud.node.Node

@OptIn(InternalBlueCloudApi::class)
fun printInformationTable() {
    Node.terminal.terminal.println(
        table {
            header {
                row {
                    cell("Key")
                    cell("Value")
                }
            }
            body {
                row {
                    cell("Operating System")
                    cell(System.getProperty("os.name"))
                }
                row {
                    cell("Operating System Version")
                    cell(System.getProperty("os.version"))
                }
                row {
                    cell("Operating System Architecture")
                    cell(System.getProperty("os.arch"))
                }
                row {
                    cell("Java Version")
                    cell(System.getProperty("java.version"))
                }
                row {
                    cell("Java Vendor")
                    cell(System.getProperty("java.vendor"))
                }
            }
        }
    )
}