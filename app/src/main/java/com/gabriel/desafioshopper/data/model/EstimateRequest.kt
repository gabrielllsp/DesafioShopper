package com.gabriel.desafioshopper.data.model

import com.google.gson.annotations.SerializedName

data class EstimateRequest(

    @SerializedName("customer_id")
    val customerId: String?,

    @SerializedName("origin")
    val origin: String?,

    @SerializedName("destination")
    val destination: String?
)
