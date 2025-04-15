package com.interswitchng.dailypulse2.di

import com.interswitchng.dailypulse2.articles.presentation.ArticlesViewModel
import com.interswitchng.dailypulse2.articles.presentation.SourcesViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.startKoin

fun initKoin(){
    val modules = sharedKoinModules + databaseModule

    startKoin { modules(modules) }
}

class ArticlesInjector: KoinComponent{
    val articlesViewModel: ArticlesViewModel by inject()
}

class SourcesInjector : KoinComponent {
    val sourcesViewModel: SourcesViewModel by inject()
}