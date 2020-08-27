package com.data.remote.request

import com.data.remote.response.PreviewResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface IGitHubService {
    @GET("lucaslmartins14/link-pocket/master/api/get_list.json")
    fun getList(): Observable<List<PreviewResponse>>
}