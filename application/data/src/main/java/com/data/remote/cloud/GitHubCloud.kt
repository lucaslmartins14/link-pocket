package com.data.remote.cloud

import com.data.remote.api.GitHubApi
import com.data.remote.response.PreviewResponse
import io.reactivex.Observable

class GitHubCloud(private val gitHubApi: GitHubApi) {

    fun getPreview(): Observable<List<PreviewResponse>> {
        return gitHubApi.getList()
    }
}