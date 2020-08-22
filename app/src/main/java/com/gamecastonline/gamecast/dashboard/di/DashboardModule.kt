package com.gamecastonline.gamecast.dashboard.di

import com.gamecastonline.gamecast.dashboard.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dashboardModule = module {
    viewModel { DashboardViewModel() }
}