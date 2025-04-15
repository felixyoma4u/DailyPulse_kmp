package com.interswitchng.dailypulse2.articles.domain

import com.interswitchng.dailypulse2.articles.data.SourcesRaw
import com.interswitchng.dailypulse2.articles.data.SourcesRepository

class SourceUseCase(private val repo: SourcesRepository) {

    suspend fun getSources(): List<Source> {
        val sourcesRaw = repo.getSources()
        return mapSources(sourcesRaw)
    }

    private fun mapSources(sourcesRaw: List<SourcesRaw>): List<Source> =
        sourcesRaw.map { raw ->
            Source(
                id = raw.id,
                name = raw.name,
                desc = raw.desc,
                origin = mapOrigin(raw)
            )
        }

    private fun mapOrigin(raw: SourcesRaw) = "${raw.country} - ${raw.language}"
}