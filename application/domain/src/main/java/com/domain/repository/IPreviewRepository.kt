package com.domain.repository

import com.domain.model.Preview
import io.reactivex.Completable
import io.reactivex.Observable

interface IPreviewRepository {
    fun getPreview() : Observable<List<Preview>>
    fun savePreview() : Completable
}