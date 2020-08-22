package com.gamecastonline.gamecast.splash.di

import com.gamecastonline.gamecast.splash.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val splashModule = module {
    viewModel { SplashScreenViewModel() }
}