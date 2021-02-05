package com.discord.rest

import io.ktor.client.HttpClient
import io.ktor.client.request.*
import io.ktor.client.statement.HttpResponse


private val defaultClient = HttpClient()

open class RestClient(
    private val baseURL: String = "https://discord.com/api",
    private val client: HttpClient = defaultClient
) {
    suspend fun get(url: String, headers: Map<String, String>): HttpResponse {
        return client.get("$baseURL$url") {
            headers.forEach { header(it.key, it.value) }
        }//.toResponse()
    }

    suspend fun post() {

    }
}