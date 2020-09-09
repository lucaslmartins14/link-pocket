package com.data.mapper

import com.data.datasource.PreviewData
import com.data.local.db.entity.PreviewEntity

class PreviewEntityToDataMapper : IMapper<PreviewEntity, PreviewData> {

    override fun transform(data: PreviewEntity): PreviewData {
        return PreviewData(
            name = data.name,
            description = data.description,
            image = data.image
        )
    }
}