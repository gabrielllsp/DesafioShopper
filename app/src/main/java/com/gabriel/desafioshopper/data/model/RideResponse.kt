package com.gabriel.desafioshopper.data.model

import com.gabriel.desafioshopper.domain.model.Driver
import com.google.gson.annotations.SerializedName

data class RideResponse(
    @SerializedName("date")
    val date: String,
    @SerializedName("destination")
    val destination: String,
    @SerializedName("distance")
    val distance: String,
    @SerializedName("driver")
    val driver: Driver,
    @SerializedName("duration")
    val duration: Double,
    @SerializedName("id")
    val id: Int,
    @SerializedName("origin")
    val origin: String,
    @SerializedName("value")
    val value: Double
)