package com.gabriel.desafioshopper.data.model

import com.google.gson.annotations.SerializedName

data class RideOptionResponse(

    @SerializedName("id")
    val id: Int,

    @SerializedName("description")
    val description: String?,

    @SerializedName("name")
    val name: String,

    @SerializedName("vehicle")
    val vehicle: String?,

    @SerializedName("review")
    val reviewResponse: ReviewResponse,

    @SerializedName("value")
    val value: Double
)