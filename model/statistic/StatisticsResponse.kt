package com.example.fypkotlin.model.statistic


import com.google.gson.annotations.SerializedName
import com.example.fypkotlin.model.statistic.Api

data class StatisticsResponse(
    @SerializedName("api")
    var api: Api
)