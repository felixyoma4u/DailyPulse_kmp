package com.interswitchng.dailypulse2.articles.presentation

import com.interswitchng.dailypulse2.articles.domain.Source

data class SourcesState(
    val sources: List<Source> = listOf(),
    val loading: Boolean = false,
    val error: String? = null
)
