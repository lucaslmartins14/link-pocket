package com.domain.di

import com.domain.GetListUseCase
import org.koin.dsl.module

object DomainModule {
    val module = module {
        factory { GetListUseCase() }
    }
}