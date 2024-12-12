package com.gabriel.desafioshopper.data.model

import com.gabriel.desafioshopper.domain.model.Driver
import com.google.gson.annotations.SerializedName


data class ConfirmRideRequest(

    @SerializedName("customer_id")
    val customerId: String,

    @SerializedName("destination")
    val destination: String,

    @SerializedName("distance")
    val distance: Double,

    @SerializedName("driver")
    val driver: Driver,

    @SerializedName("duration")
    val duration: String,

    @SerializedName("origin")
    val origin: String,

    @SerializedName("value")
    val value: Double
)