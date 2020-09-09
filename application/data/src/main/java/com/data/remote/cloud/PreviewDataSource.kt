package com.data.remote.cloud

import com.data.ErrorException
import com.data.datasource.IPreviewDataSource
import com.data.datasource.PreviewData
import com.data.mapper.PreviewResponseToDataMapper
import com.data.remote.api.GitHubApi
import io.reactivex.Observable
import retrofit2.HttpException
import java.net.UnknownHostException

class PreviewDataSource(private val gitHubApi: GitHubApi) : IPreviewDataSource {

    private val mapper = PreviewResponseToDataMapper()

    override fun getList(): Observable<List<PreviewData>> {
        return gitHubApi.getList()
            .map { mapper.transform(it) }
            .onErrorResumeNext { error: Throwable ->
                if (error is HttpException && error.code() == 400) {
                    Observable.error(ErrorException.BadException)
                } else if (error is UnknownHostException) {
                    Observable.error(ErrorException.BadException)
                } else {
                    Observable.error(error)
                }
            }
    }
}