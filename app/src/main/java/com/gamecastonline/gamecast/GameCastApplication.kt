package com.gamecastonline.gamecast

import android.app.Application
import com.gamecastonline.gamecast.dashboard.di.dashboardModule
import com.gamecastonline.gamecast.di.apiModule
import com.gamecastonline.gamecast.di.networkModule
import com.gamecastonline.gamecast.splash.di.splashModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GameCastApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // declare used Android context
            androidContext(this@GameCastApplication)
            // declare modules
            modules(
                apiModule,
                networkModule,
                splashModule,
                dashboardModule
            )
        }
    }
}