package com.interswitchng.dailypulse2.articles.data

import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleRaw>
)

