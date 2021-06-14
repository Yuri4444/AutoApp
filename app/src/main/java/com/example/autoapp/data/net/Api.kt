package com.example.autoapp.data.net

import com.example.autoapp.data.model.Auto
import com.example.autoapp.data.model.AutoDetail
//import com.example.autoapp.data.model.AutoMain
import retrofit2.http.GET

interface Api {

    @GET("v3/3ba690e4-4ae1-4a43-baad-0d3ea276aff8")
//    @GET("Auto")
//    suspend fun getAllAuto() : List<AutoMain>
    suspend fun getAllAuto() : List<Auto>

    @GET("v3/775840c1-596f-4e8b-b0c8-dc769f883c2e")
    suspend fun getDetailAuto() : List<AutoDetail>

    suspend fun getCar() : List<Auto>
    suspend fun getCarDetail() : List<AutoDetail>
}