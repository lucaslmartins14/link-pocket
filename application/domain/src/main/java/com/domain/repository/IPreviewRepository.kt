package com.domain.repository

import com.domain.model.Preview
import io.reactivex.Observable

interface IPreviewRepository {
    fun getPreview() : Observable<List<Preview>>
}