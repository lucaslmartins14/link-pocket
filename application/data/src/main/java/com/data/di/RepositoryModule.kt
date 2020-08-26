package com.data.di

import com.data.repository.PreviewRepository
import com.domain.repository.IPreviewRepository
import org.koin.dsl.module

object RepositoryModule {
    val module = module {
        factory<IPreviewRepository> { PreviewRepository() }
    }
}