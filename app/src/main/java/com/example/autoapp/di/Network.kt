package com.example.autoapp.di

import com.example.autoapp.data.networkRetrofit.AuthInterceptor
import com.example.autoapp.data.networkRetrofit.provideForecastApi
import com.example.autoapp.data.networkRetrofit.provideOkHttpClient
import com.example.autoapp.data.networkRetrofit.provideRetrofit
import org.koin.dsl.module

val networkModule = module {
    factory { AuthInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideForecastApi(get()) }
    single { provideRetrofit(get()) }
}