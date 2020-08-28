package com.data.repository

import com.data.mapper.PreviewMapper
import com.data.remote.cloud.GitHubCloud
import com.domain.model.Preview
import com.domain.repository.IPreviewRepository
import io.reactivex.Completable
import io.reactivex.Observable

class PreviewRepository(private val gitHubCloud: GitHubCloud) : IPreviewRepository {

    private val mapper = PreviewMapper()

    override fun getPreview(): Observable<List<Preview>> {
        return gitHubCloud
            .getPreview()
            .flatMapIterable { it }
            .map { value -> mapper.transform(value) }
            .toList()
            .toObservable()
    }

    override fun savePreview(): Completable {
        return gitHubCloud.savePreview()
    }
}