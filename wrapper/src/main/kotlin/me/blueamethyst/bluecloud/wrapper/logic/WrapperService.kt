package me.blueamethyst.bluecloud.wrapper.logic

import me.blueamethyst.bluecloud.wrapper.Wrapper

class WrapperService(
    javaCommand: String,
    jvmArguments: String,
    startFileName: String,
    processArguments: String
) {
    val process = Wrapper.processType.constructors.firstOrNull()!!.call()
    val startCommand = "$javaCommand $jvmArguments -jar $startFileName $processArguments"
}