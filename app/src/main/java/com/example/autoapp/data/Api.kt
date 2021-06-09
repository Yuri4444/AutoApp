package com.example.autoapp.data

import retrofit2.http.GET

interface Api {

    @GET("autos")
    suspend fun getAllAuto() : List<AutoModel>
}