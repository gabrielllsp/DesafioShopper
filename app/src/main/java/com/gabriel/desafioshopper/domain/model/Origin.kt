package com.gabriel.desafioshopper.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Origin(

    val latitude: Double?,
    val longitude: Double?
) : Parcelable