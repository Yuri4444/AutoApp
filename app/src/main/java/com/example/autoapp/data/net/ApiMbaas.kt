package com.example.autoapp.data.net

import com.example.autoapp.data.model.AutoDetail
import com.example.autoapp.utils.mbass.Defaults
import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiMbaas {

    @Headers(
        "application-id: ${Defaults.APPLICATION_ID}",
        "secret-key: ${Defaults.API_KEY}",
        "application-type: ${Defaults.REST_API_KEY}"
    )

    fun setNewAuto() : AutoDetail

    fun getAutoById(id: String): AutoDetail

    @GET("/myAutoList/data/tables/AutoListDetail")
    fun getAutoList(): AutoDetail

}