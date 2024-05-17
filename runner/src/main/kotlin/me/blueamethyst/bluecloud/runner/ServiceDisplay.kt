package me.blueamethyst.bluecloud.runner

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


/**
 * The ServiceDisplay class represents a display attached to a service.
 *
 * @param process The Process object representing the service process.
 * @author JulixnDev
 */
class ServiceDisplay(private val process: Process) {

    private var outputStreamWriter: OutputStreamWriter? = null

    val mainScope = CoroutineScope(Dispatchers.IO)

    fun adaptOutAndResolveIn() {
        mainScope.launch {
            val cliReader = BufferedReader(InputStreamReader(System.`in`))

            var line: String?
            line = cliReader.readLine()
            while (line != null) {
                println(line)
                executeCommand(line)

                line = cliReader.readLine()
            }
        }

        printOutput()
    }

    /**
     * This function reads the output from the input stream of the process
     * and prints each line to the console.
     */
    fun printOutput() {
        val inputStream = process.inputStream
        val inputReader = BufferedReader(InputStreamReader(inputStream))

        var line: String?
        line = inputReader.readLine()
        while (line != null) {
            println(line)

            line = inputReader.readLine()
        }
    }

    /**
     * Executes a command by writing it to the process output stream.
     *
     * @param command The command to be executed.
     */
    fun executeCommand(command: String) {
        if(outputStreamWriter == null)
            outputStreamWriter = OutputStreamWriter(process.outputStream)

        val writer = BufferedWriter(outputStreamWriter!!)
        writer.write(command)
        writer.flush()
    }
}