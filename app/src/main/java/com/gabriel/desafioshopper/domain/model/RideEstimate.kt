package com.gabriel.desafioshopper.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RideEstimate(
    val origin: Origin,
    val destination: Destination,
    val distance: Double,
    val duration: String,
    val options: List<RideOption>,
//    val routeResponse: String?
) : Parcelable
