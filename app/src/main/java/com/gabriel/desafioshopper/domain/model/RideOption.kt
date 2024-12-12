package com.gabriel.desafioshopper.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RideOption(

    val id: Int,
    val description: String?,
    val name: String,
    val vehicle: String?,
    val reviewResponse: Review?,
    val value: Double
) : Parcelable