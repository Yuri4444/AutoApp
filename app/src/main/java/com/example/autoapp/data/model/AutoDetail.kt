package com.example.autoapp.data.model

import com.google.gson.annotations.SerializedName

class AutoDetail {

    @SerializedName("id")
    var id: String? = null
    @SerializedName("image")
    var image: String? = null
    @SerializedName("title")
    var title: String? = null
    @SerializedName("producer")
    var producer: String? = null
    @SerializedName("model")
    var model: String? = null
    @SerializedName("year")
    var year: String? = null
    @SerializedName("cost")
    var cost: String? = null
    @SerializedName("stateImage")
    var stateImage: String? = null
}