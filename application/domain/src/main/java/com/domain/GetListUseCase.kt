package com.domain

import com.domain.model.Preview
import com.domain.repository.IPreviewRepository
import io.reactivex.Observable

class GetListUseCase(private val previewRepository: IPreviewRepository) {

    fun getPreview() : Observable<List<Preview>>{
        return previewRepository.getPreview()
    }

}