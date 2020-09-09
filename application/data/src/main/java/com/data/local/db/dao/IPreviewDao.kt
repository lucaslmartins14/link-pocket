package com.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.data.local.db.entity.PreviewEntity

@Dao
interface IPreviewDao {

    @Insert
    fun addAll(vararg previews: PreviewEntity)

    @Query("SELECT * FROM preview")
    fun getAll(): List<PreviewEntity>
}