package com.data.repository

import com.data.ErrorException
import com.data.local.db.PreviewCache
import com.data.mapper.PreviewMapper
import com.data.remote.cloud.GitHubCloud
import com.domain.model.Preview
import com.domain.repository.IPreviewRepository
import io.reactivex.Observable

class PreviewRepository(private val gitHubCloud: GitHubCloud, private val previewCache: PreviewCache) : IPreviewRepository {

    private val mapper = PreviewMapper()

    override fun getPreview(): Observable<List<Preview>> {
        return gitHubCloud
            .getPreview()
            .doOnNext { list ->
                val entities = list.map {
                    mapper.transformResponseToEntity(it)
                }

                previewCache.addAll(*entities.toTypedArray())
            }
            .flatMapIterable { it }
            .map { value -> mapper.transformResponseToModel(value) }
            .toList()
            .toObservable()
            .onErrorResumeNext { error: Throwable ->
                if(error is ErrorException.BadException) {
                    previewCache.getAllObservableSync()
                        .flatMapIterable { it }
                        .map { value ->
                            mapper.transformEntityToModel(value)
                        }
                        .toList()
                        .toObservable()

                } else {
                    Observable.error(error)
                }
            }
    }
}