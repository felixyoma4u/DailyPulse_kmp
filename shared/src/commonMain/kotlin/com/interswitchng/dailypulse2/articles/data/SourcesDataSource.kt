package com.interswitchng.dailypulse2.articles.data

import com.interswitchng.dailypulse2.db.DailyPulseDatabase

class SourcesDataSource(private val database: DailyPulseDatabase) {

    fun getAllSources(): List<SourcesRaw> =
        database.dailyPulseDatabaseQueries.selectAllSources(::mapToSourcesRaw).executeAsList()

    fun insertSourcesRaw(sources: List<SourcesRaw>){
        database.dailyPulseDatabaseQueries.transaction {
            sources.forEach { source->
                insertSources(source)
            }
        }
    }

    fun clearSources() = database.dailyPulseDatabaseQueries.removeAllSources()

    private fun insertSources(sourcesRaw: SourcesRaw) {
        database.dailyPulseDatabaseQueries.insertSource(
            sourcesRaw.id,
            sourcesRaw.name,
            sourcesRaw.desc,
            sourcesRaw.language,
            sourcesRaw.country
        )
    }

    private fun mapToSourcesRaw(
        id: String,
        name: String,
        desc: String,
        language: String,
        country: String
    ) =
        SourcesRaw(id, name, desc, language, country)
}