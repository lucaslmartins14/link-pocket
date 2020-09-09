package com.data.datasource

import io.reactivex.Observable

interface IPreviewDataStore {
    fun getList(): Observable<List<PreviewData>>
}