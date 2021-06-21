package com.example.autoapp.di

import com.example.autoapp.data.networkMbaas.AuthInterceptorMbaas
import com.example.autoapp.data.networkMbaas.provideForecastApiMbaas
import com.example.autoapp.data.networkMbaas.provideOkHttpClientMbaas
import com.example.autoapp.data.networkMbaas.provideRetrofitMbaas
import org.koin.core.qualifier.named
import org.koin.dsl.module

val networkModuleMbaas = module {
    factory { AuthInterceptorMbaas() }
    factory(named("OkHttpMbaas")) { provideOkHttpClientMbaas(get()) }
    factory { provideForecastApiMbaas(get()) }
    single(named("RetrofitMbaas")) { provideRetrofitMbaas(get()) }
}