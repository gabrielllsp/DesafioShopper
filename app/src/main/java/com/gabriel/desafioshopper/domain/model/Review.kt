package com.gabriel.desafioshopper.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Review(
    val rating: Double?,
    val comment: String?
) : Parcelable