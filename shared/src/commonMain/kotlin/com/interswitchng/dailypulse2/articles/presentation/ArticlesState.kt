package com.interswitchng.dailypulse2.articles.presentation

import com.interswitchng.dailypulse2.articles.domain.Article

data class ArticlesState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
