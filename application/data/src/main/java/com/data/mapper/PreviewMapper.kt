package com.data.mapper

import com.data.remote.response.PreviewResponse
import com.domain.model.Preview

class PreviewMapper {

    fun transform(previewResponse: PreviewResponse) : Preview {
       return Preview(
           name = previewResponse.name,
           description = previewResponse.description,
           image = previewResponse.image
       )
    }
}