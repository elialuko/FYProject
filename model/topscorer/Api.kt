package com.example.fypkotlin.model.topscorer


import com.google.gson.annotations.SerializedName

data class Api(
    @SerializedName("results")
    var results: Int,
    @SerializedName("topscorers")
    var topscorers: List<Topscorer>
)