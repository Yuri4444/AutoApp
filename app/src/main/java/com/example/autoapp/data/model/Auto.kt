package com.example.autoapp.data.model

import com.google.gson.annotations.SerializedName

class Auto {

    @SerializedName("id")
    var id: String = ""

    @SerializedName("title")
    var title: String = ""

    @SerializedName("image")
    var image: String = ""

}