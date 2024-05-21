package me.blueamethyst.bluecloud.node.server.routes

import io.ktor.server.application.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlinx.coroutines.channels.consumeEach

fun Application.nodeRoutes() {
    routing {
        // TODO: Authentication
        webSocket("/node") {

            kotlin.runCatching {
                incoming.consumeEach { frame ->
                    if (frame is Frame.Text) {
                        val text = frame.readText()
                    }
                }
            }
        }
    }
}