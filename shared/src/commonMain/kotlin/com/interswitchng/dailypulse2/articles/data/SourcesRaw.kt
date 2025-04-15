package com.interswitchng.dailypulse2.articles.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourcesRaw(
    val id: String,
    val name: String,
    @SerialName("description")
    val desc: String,
    val language: String,
    val country: String
)
