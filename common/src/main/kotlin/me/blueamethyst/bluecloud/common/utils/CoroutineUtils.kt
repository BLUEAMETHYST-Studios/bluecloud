package me.blueamethyst.bluecloud.common.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

object CoroutineUtils {
    val internalCoroutineScope = CoroutineScope(Dispatchers.IO)
}