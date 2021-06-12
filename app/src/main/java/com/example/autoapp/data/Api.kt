package com.example.autoapp.data

import retrofit2.http.GET

interface Api {

    @GET("v3/34dfaa81-4d84-4fd5-87f8-7c300adbe962")
    suspend fun getAllAuto() : List<Auto>

    @GET("v3/ec02f26b-5668-496c-a802-a55cd3d99d0c")
    suspend fun getDetailAuto() : List<AutoDetail>
}