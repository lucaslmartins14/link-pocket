package com.data.di

import com.data.local.db.PreviewCache
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

object DatabaseModule {
    val module = module {
        factory { PreviewCache(androidContext()) }
    }
}