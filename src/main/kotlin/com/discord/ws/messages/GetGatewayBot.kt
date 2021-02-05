package com.discord.ws.messages

import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class GetGatewayBot(
    val url: String,
    val shards: Int,
    val session_start_limit: SessionStartLimit
)

@Serializable
data class SessionStartLimit(
    val total: Int,
    val remaining: Int,
    val reset_after: Int,
    val max_concurrency: Int
)