package com.example.fypkotlin.model.topscorer


import com.google.gson.annotations.SerializedName

data class TopScorerResponse(
    @SerializedName("api")
    var api: Api
)