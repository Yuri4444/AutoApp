package com.example.autoapp.data

import com.google.gson.annotations.SerializedName

data class Auto(

    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("image")
    val image: String = ""
)