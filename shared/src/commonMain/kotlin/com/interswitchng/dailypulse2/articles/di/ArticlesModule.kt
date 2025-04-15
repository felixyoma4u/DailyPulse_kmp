package com.interswitchng.dailypulse2.articles.di

import com.interswitchng.dailypulse2.articles.data.ArticlesDataSource
import com.interswitchng.dailypulse2.articles.data.ArticlesRepository
import com.interswitchng.dailypulse2.articles.data.ArticlesService
import com.interswitchng.dailypulse2.articles.domain.ArticlesUseCase
import com.interswitchng.dailypulse2.articles.presentation.ArticlesViewModel
import org.koin.dsl.module

val articlesModule = module {
    single<ArticlesService> { ArticlesService(get()) }
    single<ArticlesUseCase> { ArticlesUseCase(get()) }
    single<ArticlesViewModel> { ArticlesViewModel(get()) }
    single<ArticlesDataSource> { ArticlesDataSource(get()) }
    single<ArticlesRepository> { ArticlesRepository(get(), get()) }
}