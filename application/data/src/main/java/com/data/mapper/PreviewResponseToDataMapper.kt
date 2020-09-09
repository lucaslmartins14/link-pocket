package com.data.mapper

import com.data.datasource.PreviewData
import com.data.remote.response.PreviewResponse

class PreviewResponseToDataMapper : IMapper<PreviewResponse, PreviewData> {

    override fun transform(data: PreviewResponse): PreviewData {
        return PreviewData(
            name = data.name,
            description = data.description,
            image = data.image
        )
    }
}