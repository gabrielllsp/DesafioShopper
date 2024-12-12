package com.gabriel.desafioshopper.data.model

import com.google.gson.annotations.SerializedName

data class RideEstimateResponse(

    @SerializedName("origin")
    val origin: OriginResponse,

    @SerializedName("destination")
    val destination: DestinationResponse,

    @SerializedName("distance")
    val distance: Double,

    @SerializedName("duration")
    val duration: String,

    @SerializedName("options")
    val options: List<RideOptionResponse>,

//    @SerializedName("routeResponse")
//    val routeResponse: String?
)
