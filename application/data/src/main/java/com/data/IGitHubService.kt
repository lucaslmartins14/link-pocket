package com.data

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface IGitHubService {

    @GET("lucaslmartins14/link-pocket/master/api/get_list.json")
    fun getList(@Query("token") token: String = "AM5CJVVF2GEPT26LYBFQTDS7IWGOC"): Observable<List<PreviewResponse>>

}