package com.example.fypkotlin.model.leaguetable


import com.google.gson.annotations.SerializedName

data class LeagueTableResponse(
    @SerializedName("api")
    var api: Api
)