package com.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.data.local.db.dao.PreviewDao
import com.data.local.db.entity.PreviewEntity

@Database(entities = [PreviewEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun previewDao(): PreviewDao
}

object DatabaseBuilder {

    private var instance: AppDatabase? = null

    fun getAppDatabase(context: Context) = instance ?: build(context)

    private fun build(context: Context): AppDatabase {
        val database = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "database-link_pocket")
            .build()
        instance = database
        return database
    }
}