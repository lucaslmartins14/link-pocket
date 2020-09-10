package com.data.di

import com.data.local.db.PreviewDao
import com.data.local.db.dao.IPreviewDao
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DatabaseModule {
    val module = module {
        factory<IPreviewDao> { PreviewDao(androidContext()) }
    }
}