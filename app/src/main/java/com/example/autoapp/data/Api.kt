package com.example.autoapp.data

import retrofit2.http.GET

interface Api {

    @GET("v3/3021ec1f-b702-4b60-a6f6-ae3f919016d1")
    suspend fun getAllAuto() : List<Auto>

    @GET("v3/ff5c4c3e-7e40-4e93-985c-b8751c0257d9")
    suspend fun getDetailAuto() : List<AutoDetail>
}