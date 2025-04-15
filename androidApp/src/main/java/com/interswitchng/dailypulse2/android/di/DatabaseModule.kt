package com.interswitchng.dailypulse2.android.di

import app.cash.sqldelight.db.SqlDriver
import com.interswitchng.dailypulse2.db.DailyPulseDatabase
import com.interswitchng.dailypulse2.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}