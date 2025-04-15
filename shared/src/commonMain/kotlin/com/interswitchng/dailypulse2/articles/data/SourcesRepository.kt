package com.interswitchng.dailypulse2.articles.data

class SourcesRepository(
    private val dataSource: SourcesDataSource,
    private val service: SourcesService
) {

    suspend fun getSources(): List<SourcesRaw>{
        val sourceDb = dataSource.getAllSources()

        if (sourceDb.isEmpty()){
            dataSource.clearSources()
            val fetchSources = service.fetchSources()
            dataSource.insertSourcesRaw(fetchSources)
            return fetchSources
        }
        return sourceDb
    }
}