package com.data.remote.service

import com.data.remote.HTTPClient
import com.data.remote.request.IGitHubService

class GitHubService(private val httpClient: HTTPClient) {
    fun getPreview() : IGitHubService {
        return httpClient.getRetrofit(IGitHubService::class)
    }
}