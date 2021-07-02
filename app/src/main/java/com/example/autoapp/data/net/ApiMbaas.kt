package com.example.autoapp.data.net

import com.example.autoapp.data.model.AutoList
import retrofit2.http.GET

interface ApiMbaas {

//    @Headers(
//        "application-id: ${Defaults.APPLICATION_ID}",
//        "secret-key: ${Defaults.API_KEY}",
//        "application-type: ${Defaults.REST_API_KEY}"
//    )


    @GET("/myAutoList/data/tables/AutoList")
    fun getAutoList(): List<AutoList>

}