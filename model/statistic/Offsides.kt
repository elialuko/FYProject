package com.example.fypkotlin.model.statistic


import com.google.gson.annotations.SerializedName

data class Offsides(
    @SerializedName("home")
    var home: String,
    @SerializedName("away")
    var away: String
)