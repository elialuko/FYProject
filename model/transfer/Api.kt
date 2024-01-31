package com.example.fypkotlin.model.transfer


import com.google.gson.annotations.SerializedName

data class Api(
    @SerializedName("results")
    var results: Int,
    @SerializedName("transfers")
    var transfers: List<Transfer>
)