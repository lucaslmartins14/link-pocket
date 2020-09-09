package com.data.di

import com.data.remote.api.GitHubApi
import com.data.remote.cloud.PreviewDataSource
import com.data.remote.network.HTTPClient
import org.koin.dsl.module

object NetworkModule {

    val module = module {
        single { HTTPClient() }
        factory { get<HTTPClient>().create(GitHubApi::class) }
        factory { PreviewDataSource(get()) }
    }
}