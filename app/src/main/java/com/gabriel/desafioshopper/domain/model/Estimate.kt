package com.gabriel.desafioshopper.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Estimate(
    val customerId: String?,
    val origin: String?,
    val destination: String?
) : Parcelable
