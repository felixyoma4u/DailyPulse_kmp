package com.interswitchng.dailypulse2.articles.domain

import com.interswitchng.dailypulse2.articles.data.ArticleRaw
import com.interswitchng.dailypulse2.articles.data.ArticlesRepository
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.daysUntil
import kotlinx.datetime.toLocalDateTime
import kotlinx.datetime.todayIn
import kotlin.math.abs

class ArticlesUseCase(private val repo: ArticlesRepository) {

    suspend fun getArticles(forceFetch: Boolean): List<Article> {
        val articlesRaw = repo.getArticles(forceFetch)
        return mapArticles(articlesRaw)
    }

    private fun mapArticles(articlesRaw: List<ArticleRaw>): List<Article> = articlesRaw.map { raw ->
        Article(
            title = raw.title,
            desc = raw.desc ?: "Click to find more",
            date = getDaysAgoString(raw.date),
            imageUrl = raw.imageUrl
                ?: "https://image.cnbcfm.com/api/v1/image/107068967-16539991923ED2-REQ-053122-NewsPRE2.jpg"
        )
    }

    private fun getDaysAgoString(date: String): String{
        val today = Clock.System.todayIn(TimeZone.currentSystemDefault())
        val days = today.daysUntil(
            Instant.parse(date).toLocalDateTime(TimeZone.currentSystemDefault()).date
        )
        val result = when{
            abs(days) > 1 -> "${abs(days)} days ago"
            abs(days) == 1 -> "Yesterday"
            else -> "Today"
        }
        return result
    }
}