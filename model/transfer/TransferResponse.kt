package com.example.fypkotlin.model.transfer


import com.google.gson.annotations.SerializedName

data class TransferResponse(
    @SerializedName("api")
    var api: Api
)