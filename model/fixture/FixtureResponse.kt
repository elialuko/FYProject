package com.example.fypkotlin.model.fixture


import com.google.gson.annotations.SerializedName

data class FixtureResponse(
    @SerializedName("api")
    var api: Api
)