package com.linkpocket

import android.app.Application
import com.domain.di.DomainModule
import com.linkpocket.di.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PocketApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PocketApplication)
            modules(PresentationModule.module, DomainModule.module)
        }
    }
}