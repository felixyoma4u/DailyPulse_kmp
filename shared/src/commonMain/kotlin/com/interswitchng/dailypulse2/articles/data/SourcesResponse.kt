package com.interswitchng.dailypulse2.articles.data

import kotlinx.serialization.Serializable

@Serializable
data class SourcesResponse(
    val status: String,
    val sources: List<SourcesRaw>
)
