package com.data.datasource

import io.reactivex.Observable

interface IPreviewDataSource {
    fun getList(): Observable<List<PreviewData>>
}