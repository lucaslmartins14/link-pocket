package com.data.di

import com.data.remote.HTTPClient
import com.data.remote.service.GitHubService
import org.koin.dsl.module

object NetworkModule {
    val module = module {
        single { HTTPClient() }
        factory { GitHubService(get()) }
    }
}