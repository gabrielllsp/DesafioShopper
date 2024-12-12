package com.gabriel.desafioshopper.data.model

import com.google.gson.annotations.SerializedName

data class DriverResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)