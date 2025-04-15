package com.interswitchng.dailypulse2.android

import android.app.Application
import com.interswitchng.dailypulse2.android.di.databaseModule
import com.interswitchng.dailypulse2.android.di.viewModelsModule
import com.interswitchng.dailypulse2.di.sharedKoinModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DailyPulseApp: Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        val modules = sharedKoinModules + viewModelsModule + databaseModule
        startKoin {
            androidContext(this@DailyPulseApp)
            modules(modules)
        }
    }
}