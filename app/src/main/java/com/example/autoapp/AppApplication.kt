package com.example.autoapp

import android.app.Application
import com.example.autoapp.data.network.networkModule
import com.example.autoapp.domain.autoRepositoryModule
import com.example.autoapp.ui.main.mainFragmentModule
import com.example.autoapp.ui.main.mainFragmentViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
            modules(listOf(networkModule, autoRepositoryModule, mainFragmentModule, mainFragmentViewModel))
        }
    }
}