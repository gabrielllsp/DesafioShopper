package com.gabriel.desafioshopper.data.model

import com.google.gson.annotations.SerializedName

data class ReviewResponse(

    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("comment")
    val comment: String?
)