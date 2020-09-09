package com.data.local.db

import android.content.Context
import com.data.local.db.dao.IPreviewDao
import com.data.local.db.entity.PreviewEntity

class PreviewDao(context: Context) : IPreviewDao {

    private val dao = DatabaseBuilder.getAppDatabase(context).previewDao()

    override fun addAll(vararg previews: PreviewEntity) {
        dao.addAll(*previews)
    }

    override fun getAll(): List<PreviewEntity> {
        return dao.getAll()
    }
}