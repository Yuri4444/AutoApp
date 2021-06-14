package com.example.autoapp.di

import com.example.autoapp.data.networkBackendless.AuthInterceptorGallery
import com.example.autoapp.data.networkBackendless.provideForecastApiGallery
import com.example.autoapp.data.networkBackendless.provideOkHttpClientGallery
import com.example.autoapp.data.networkBackendless.provideRetrofitGallery
import org.koin.dsl.module

val networkModuleGallery = module {
    factory { AuthInterceptorGallery() }
    factory { provideOkHttpClientGallery(get()) }
    factory { provideForecastApiGallery(get()) }
    single { provideRetrofitGallery(get()) }
}