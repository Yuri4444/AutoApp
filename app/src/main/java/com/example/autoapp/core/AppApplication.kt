package com.example.autoapp.core

import android.app.Application
import com.example.autoapp.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
//            modules(listOf(networkModule, networkModuleMbaas, autoRepositoryModule, fragmentModule, fragmentViewModelModule))
            modules(listOf(networkModule, autoRepositoryModule, fragmentModule, fragmentViewModelModule))
        }
    }
}