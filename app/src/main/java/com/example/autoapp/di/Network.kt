package com.example.autoapp.di

import com.example.autoapp.data.network.AuthInterceptor
import com.example.autoapp.data.network.provideForecastApi
import com.example.autoapp.data.network.provideOkHttpClient
import com.example.autoapp.data.network.provideRetrofit
import org.koin.dsl.module

val networkModule = module {
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideForecastApi(get()) }
    single { provideRetrofit(get()) }
}