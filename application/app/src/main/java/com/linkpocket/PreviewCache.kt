package com.linkpocket

import android.content.Context
import com.linkpocket.entity.PreviewEntity

class PreviewCache(context: Context) {

    private val database = DatabaseBuilder.getAppDatabase(context)
    private val accessPreview = database.previewDao()

    fun addAll(vararg previews: PreviewEntity) {
        Thread {
            accessPreview.addAll(*previews)
        }.start()

    }

    fun delete(previews: PreviewEntity) {
        accessPreview.delete(previews)
    }

    fun update(previews: PreviewEntity) {
        accessPreview.update(previews)
    }

    fun getAll(): List<PreviewEntity> {
        return accessPreview.getAll()
    }

    interface Action {

        fun onFinish()
    }
}