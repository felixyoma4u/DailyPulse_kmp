package com.interswitchng.dailypulse2.articles.data

class ArticlesRepository(
    private val dataSource: ArticlesDataSource,
    private val service: ArticlesService
) {

    suspend fun getArticles(forceFetch: Boolean): List<ArticleRaw>{
        if (forceFetch){
            dataSource.clearArticles()
            return fetchArticles()
        }
        val articlesDb = dataSource.getAllArticles()
        println("Got ${articlesDb.size} from database!!")
        if (articlesDb.isEmpty()){
            return fetchArticles()
        }
        return articlesDb
    }

    private suspend fun fetchArticles(): List<ArticleRaw> {
        println("Fetching new articles...")
        val fetchedArticles = service.fetchArticles()
        dataSource.insertArticlesRaw(fetchedArticles)
        return fetchedArticles
    }
}