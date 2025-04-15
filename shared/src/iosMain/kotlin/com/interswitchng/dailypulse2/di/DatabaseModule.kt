package com.interswitchng.dailypulse2.di

import app.cash.sqldelight.db.SqlDriver
import com.interswitchng.dailypulse2.db.DailyPulseDatabase
import com.interswitchng.dailypulse2.db.DatabaseDriverFactory
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory().createDriver() }
    single<DailyPulseDatabase> { DailyPulseDatabase(get()) }
}