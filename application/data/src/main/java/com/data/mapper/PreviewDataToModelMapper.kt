package com.data.mapper

import com.data.datasource.PreviewData
import com.domain.model.Preview

class PreviewDataToModelMapper : IMapper<PreviewData, Preview> {

    override fun transform(data: PreviewData): Preview {
        return Preview(
            name = data.name,
            description = data.description,
            image = data.image
        )
    }
}