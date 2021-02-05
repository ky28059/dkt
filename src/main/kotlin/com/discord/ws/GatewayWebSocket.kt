package com.discord.ws

import com.discord.Client
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.get
import io.ktor.client.features.websocket.*
import io.ktor.client.request.*
import io.ktor.http.cio.websocket.*

class GatewayWebSocket(
    val token: String,
    val bot: Client
) {
    private val client = HttpClient {
        install(WebSockets)
    }

    suspend fun initConnection() {
        client.wss(
            path = bot.getGatewayEndpoint().url
        ) {
            when (val frame = incoming.receive()) {
                is Frame.Text -> println(frame.readText())
                is Frame.Binary -> println(frame.readBytes())
            }
        }
    }
}