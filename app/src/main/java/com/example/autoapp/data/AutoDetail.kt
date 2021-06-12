package com.example.autoapp.data

import com.google.gson.annotations.SerializedName

class AutoDetail(

    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("image")
    val image: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("producer")
    val producer: String? = "",
    @SerializedName("model")
    val model: String? = "",
    @SerializedName("year")
    val year: String? = "",
    @SerializedName("cost")
    val cost: String? = ""
)