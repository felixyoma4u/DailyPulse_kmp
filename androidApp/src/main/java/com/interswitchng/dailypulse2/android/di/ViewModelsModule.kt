package com.interswitchng.dailypulse2.android.di

import com.interswitchng.dailypulse2.articles.presentation.ArticlesViewModel
import com.interswitchng.dailypulse2.articles.presentation.SourcesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {
    viewModel{ ArticlesViewModel(get()) }
    viewModel{ SourcesViewModel(get()) }

}