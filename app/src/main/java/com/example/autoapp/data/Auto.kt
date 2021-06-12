package com.example.autoapp.data

import com.google.gson.annotations.SerializedName

data class Auto(

    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String = "",
    @SerializedName("image")
    val image: String = ""
)