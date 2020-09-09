package com.data.repository

import com.data.datasource.IPreviewDataStore
import com.data.mapper.PreviewDataToModelMapper
import com.domain.model.Preview
import com.domain.repository.IPreviewRepository
import io.reactivex.Observable

class PreviewRepository(private val dataStore: IPreviewDataStore) : IPreviewRepository {

    private val mapper = PreviewDataToModelMapper()

    override fun getPreview(): Observable<List<Preview>> {
        return dataStore.getList()
            .map { mapper.transform(it) }
    }
}