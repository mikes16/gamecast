package com.gamecastonline.gamecast.di

import com.bumptech.glide.Glide
import com.gamecastonline.gamecast.network.provideApiService
import com.gamecastonline.gamecast.network.provideOkHttpClient
import com.gamecastonline.gamecast.network.provideRetrofit
import com.gamecastonline.gamecast.network.repositories.UrlRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val networkModule = module {
    factory { provideApiService(get()) }
    factory { provideOkHttpClient() }
    single { provideRetrofit(get()) }
}

val repositoriesModule = module {
    factory { UrlRepository(get()) }
}

val apiModule = module {
    single { (Glide.with(androidApplication())) }
}
