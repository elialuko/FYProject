package com.example.fypkotlin.model.h2h


import com.google.gson.annotations.SerializedName

data class H2HResponse(
    @SerializedName("api")
    var api: Api
)