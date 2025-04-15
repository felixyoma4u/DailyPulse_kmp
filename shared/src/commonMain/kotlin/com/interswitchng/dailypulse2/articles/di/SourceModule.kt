package com.interswitchng.dailypulse2.articles.di

import com.interswitchng.dailypulse2.articles.data.SourcesDataSource
import com.interswitchng.dailypulse2.articles.data.SourcesRepository
import com.interswitchng.dailypulse2.articles.data.SourcesService
import com.interswitchng.dailypulse2.articles.domain.SourceUseCase
import com.interswitchng.dailypulse2.articles.presentation.SourcesViewModel
import org.koin.dsl.module

val sourceModule = module {
    single<SourcesService> { SourcesService(get()) }
    single<SourceUseCase> { SourceUseCase(get()) }
    single<SourcesViewModel> { SourcesViewModel(get()) }
    single<SourcesDataSource> { SourcesDataSource(get()) }
    single<SourcesRepository> { SourcesRepository(get(), get()) }
}