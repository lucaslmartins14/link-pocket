package com.data.di

import com.data.datasource.IPreviewDataStore
import com.data.datasource.PreviewDataStore
import org.koin.dsl.module

object DataStoreModule {
    val module = module {
        factory<IPreviewDataStore> { PreviewDataStore(get(), get()) }
    }
}