package com.discord

import com.discord.rest.RestClient
import com.discord.ws.messages.GetGatewayBot
import io.ktor.client.statement.*
import kotlinx.serialization.*
import kotlinx.serialization.json.*

class Client(private val token: String) : RestClient() {
    suspend fun getGatewayEndpoint() = Json.decodeFromString<GetGatewayBot>(get("/gateway/bot", mapOf("Authorization" to "Bot $token")).readText())
}