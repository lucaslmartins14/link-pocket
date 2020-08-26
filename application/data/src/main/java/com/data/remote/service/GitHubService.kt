package com.data.remote.service

import com.data.remote.RetrofitInit

class GitHubService {

    fun getPreview() : IGitHubService {
        return RetrofitInit().retrofit.create(IGitHubService::class.java)
    }
}