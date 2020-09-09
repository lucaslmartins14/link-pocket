package com.data.mapper

import com.data.datasource.PreviewData
import com.data.local.db.entity.PreviewEntity

class PreviewDataToEntityMapper : IMapper<PreviewData, PreviewEntity> {
    override fun transform(data: PreviewData): PreviewEntity {
        return PreviewEntity(
            name = data.name,
            description = data.description,
            image = data.image
        )
    }
}