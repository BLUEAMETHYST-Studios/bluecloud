package me.blueamethyst.bluecloud.node.server

import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.websocket.*
import me.blueamethyst.bluecloud.api.annontations.InternalBlueCloudApi
import me.blueamethyst.bluecloud.node.Node
import me.blueamethyst.bluecloud.node.Node.Companion.logger
import me.blueamethyst.bluecloud.node.server.routes.nodeRoutes
import java.io.Closeable

class KtorApplication: Thread("ktor-thread"), Closeable {

    @OptIn(InternalBlueCloudApi::class)
    override fun start() {
        logger.info("starting ktor server on ${Node.cluster.hostname}:${Node.cluster.port}")
        embeddedServer(
            Netty,
            host = Node.cluster.hostname,
            port = Node.cluster.port,
            module = Application::module
        ).start(wait = true)
        super.start()
    }

    init {
        isDaemon = true
    }

    override fun close() {
        interrupt()
    }
}

@OptIn(InternalBlueCloudApi::class)
fun Application.module() {
    install(Authentication)
    install(WebSockets)

    authentication {
        basic {
            realm = "bluecloud"

            validate { credentials ->
                val name = credentials.name
                val password = credentials.password

                if (password == Node.secrets.clusterSecret) {
                    return@validate UserIdPrincipal(name)
                }
                return@validate null
            }
        }
    }

    nodeRoutes()
}