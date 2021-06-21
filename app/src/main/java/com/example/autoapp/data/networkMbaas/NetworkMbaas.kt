package com.example.autoapp.data.networkMbaas

import com.example.autoapp.data.net.ApiMbaas
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.example.autoapp.utils.mbass.Defaults

fun provideRetrofitMbaas(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder().baseUrl(Defaults.SERVER_URL).client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClientMbaas(authInterceptor: AuthInterceptorMbaas): OkHttpClient {
    return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
}

fun provideForecastApiMbaas(retrofit: Retrofit): ApiMbaas = retrofit.create(ApiMbaas::class.java)

//Backendless.setUrl(Defaults.SERVER_URL)
//Backendless.initApp(requireContext(), Defaults.APPLICATION_ID, Defaults.API_KEY)

class AuthInterceptorMbaas : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var req = chain.request()
        val url = req.url.newBuilder().addQueryParameter("APPID", "your_key_here").build()
        req = req.newBuilder().url(url).build()
        return chain.proceed(req)
    }
}