package com.gabriel.desafioshopper.domain.model

import android.os.Parcelable
import com.gabriel.desafioshopper.data.model.DriverResponse
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ride(
    val date: String,
    val destination: String,
    val distance: String,
    val driver: Driver,
    val duration: Double,
    val id: Int,
    val origin: String,
    val value: Double
) : Parcelable