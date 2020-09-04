package com.data.mapper

import com.data.local.db.entity.PreviewEntity
import com.data.remote.response.PreviewResponse
import com.domain.model.Preview

class PreviewMapper {

    fun transformResponseToModel(previewResponse: PreviewResponse) : Preview {
       return Preview(
           name = previewResponse.name,
           description = previewResponse.description,
           image = previewResponse.image
       )
    }

    fun transformResponseToEntity(previewResponse: PreviewResponse) : PreviewEntity {
        return PreviewEntity(
            name = previewResponse.name,
            description = previewResponse.description,
            image = previewResponse.image
        )
    }

    fun transformEntityToModel(previewEntity: PreviewEntity) : Preview {
        return Preview(
            name = previewEntity.name,
            description = previewEntity.description,
            image = previewEntity.image
        )
    }
}