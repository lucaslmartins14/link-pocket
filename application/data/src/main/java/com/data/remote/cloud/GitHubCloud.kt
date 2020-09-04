package com.data.remote.cloud

import com.data.ErrorException
import com.data.remote.api.GitHubApi
import com.data.remote.response.PreviewResponse
import io.reactivex.Observable
import retrofit2.HttpException
import java.net.UnknownHostException

class GitHubCloud(private val gitHubApi: GitHubApi) {

    fun getPreview(): Observable<List<PreviewResponse>> {
        return gitHubApi.getList()
            .onErrorResumeNext { error: Throwable ->
                if (error is HttpException && error.code() == 400) {
                    Observable.error<List<PreviewResponse>>(ErrorException.BadException)
                } else if (error is UnknownHostException) {
                    Observable.error<List<PreviewResponse>>(ErrorException.BadException)
                } else {
                    Observable.error<List<PreviewResponse>>(error)
                }
            }
    }
}