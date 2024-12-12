package com.gabriel.desafioshopper.data.model

import com.google.gson.annotations.SerializedName

data class OriginResponse(

    @SerializedName("latitude")
    val latitude: Double?,

    @SerializedName("longitude")
    val longitude: Double?
)