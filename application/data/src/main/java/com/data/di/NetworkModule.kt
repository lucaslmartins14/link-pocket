package com.data.di

import com.data.remote.api.GitHubApi
import com.data.remote.cloud.GitHubCloud
import com.data.remote.network.HTTPClient
import org.koin.dsl.module

object NetworkModule {

    val module = module {
        single { HTTPClient() }
        factory { get<HTTPClient>().create(GitHubApi::class) }
        factory { GitHubCloud(get()) }
    }
}