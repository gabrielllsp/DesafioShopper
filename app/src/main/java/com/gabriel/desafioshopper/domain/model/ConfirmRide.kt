package com.gabriel.desafioshopper.domain.model

import android.os.Parcelable
import com.gabriel.desafioshopper.data.model.DriverRequest
import kotlinx.parcelize.Parcelize

@Parcelize
data class ConfirmRide(
    val customerId: String,
    val destination: String,
    val distance: Double,
    val driver: Driver,
    val duration: String,
    val origin: String,
    val value: Double
) : Parcelable