package com.gabriel.desafioshopper.data.model

import com.gabriel.desafioshopper.domain.model.Ride
import com.google.gson.annotations.SerializedName

data class TripHistoryResponse(
    @SerializedName("customer_id")
    val customerId: String,
    @SerializedName("rides")
    val rides: List<Ride>
)