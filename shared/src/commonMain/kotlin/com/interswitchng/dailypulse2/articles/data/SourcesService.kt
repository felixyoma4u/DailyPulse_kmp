package com.interswitchng.dailypulse2.articles.data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class SourcesService(private val httpClient: HttpClient) {
    private val apiKey = "e97227d8022440d39e743f1b19624e74"

    suspend fun fetchSources(): List<SourcesRaw> {
        val response: SourcesResponse =
            httpClient.get("https://newsapi.org/v2/top-headlines/sources?apiKey=$apiKey").body()
        return response.sources
    }
}