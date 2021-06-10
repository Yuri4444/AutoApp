package com.example.autoapp.data

import com.google.gson.annotations.SerializedName

data class AutoModel(

    @SerializedName("name")
    val name: String = "",
    @SerializedName("image")
    val image: String = ""
)