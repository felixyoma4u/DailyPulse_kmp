package com.interswitchng.dailypulse2.di

import com.interswitchng.dailypulse2.articles.di.articlesModule
import com.interswitchng.dailypulse2.articles.di.sourceModule

val sharedKoinModules = listOf(
    articlesModule,
    sourceModule,
    networkModule
)