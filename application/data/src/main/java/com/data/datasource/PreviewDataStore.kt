package com.data.datasource

import android.annotation.SuppressLint
import com.data.ErrorException
import com.data.local.db.dao.IPreviewDao
import com.data.mapper.PreviewDataToEntityMapper
import com.data.mapper.PreviewEntityToDataMapper
import io.reactivex.Observable

class PreviewDataStore(
    private val dataSource: IPreviewDataSource,
    private val dao: IPreviewDao
) : IPreviewDataStore {

    private val dataToEntityMapper = PreviewDataToEntityMapper()
    private val entityToDataMapper = PreviewEntityToDataMapper()

    @SuppressLint("CheckResult")
    override fun getList(): Observable<List<PreviewData>> {
        return dataSource.getList()
            .doOnNext {
                dao.addAll(*dataToEntityMapper.transform(it).toTypedArray())
            }
            .onErrorResumeNext { error: Throwable ->
                if (error is ErrorException.BadException) {
                    Observable
                        .just(dao.getAll())
                        .map { entityToDataMapper.transform(it) }
                } else {
                    Observable.error(error)
                }
            }
    }
}