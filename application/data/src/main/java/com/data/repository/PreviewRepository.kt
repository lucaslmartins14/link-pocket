package com.data.repository

import com.data.mapper.PreviewMapper
import com.data.remote.service.GitHubService
import com.domain.model.Preview
import com.domain.repository.IPreviewRepository
import io.reactivex.Observable

class PreviewRepository : IPreviewRepository {

    private val gitHubService = GitHubService()
    private val mapper = PreviewMapper()

    override fun getPreview(): Observable<List<Preview>> {
        return gitHubService.getPreview()
            .getList()
            .flatMapIterable { it }
            .map { value -> mapper.transform(value) }
            .toList()
            .toObservable()
    }
}