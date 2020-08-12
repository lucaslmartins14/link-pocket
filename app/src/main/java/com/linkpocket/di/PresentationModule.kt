package com.linkpocket.di

import com.linkpocket.ui.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object PresentationModule {
    val module = module {
        viewModel { MainViewModel() }
    }
}