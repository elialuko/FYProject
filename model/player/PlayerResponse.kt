package com.example.fypkotlin.model.player


import com.google.gson.annotations.SerializedName

data class PlayerResponse(
    @SerializedName("api")
    var api: Api
)