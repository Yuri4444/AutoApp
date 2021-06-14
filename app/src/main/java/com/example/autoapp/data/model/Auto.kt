package com.example.autoapp.data.model

import com.google.gson.annotations.SerializedName

//data class AutoMain (
//    @SerializedName("autoList")
//    val auto : List<Auto>
//)

data class Auto(

    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("image")
    val image: String = "",
)