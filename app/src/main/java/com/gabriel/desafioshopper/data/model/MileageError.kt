package com.gabriel.desafioshopper.data.model

import com.google.gson.annotations.SerializedName

data class MileageError(

    @SerializedName("error_code")
    val errorCode: String,

    @SerializedName("error_description")
    val errorDescription: String
)