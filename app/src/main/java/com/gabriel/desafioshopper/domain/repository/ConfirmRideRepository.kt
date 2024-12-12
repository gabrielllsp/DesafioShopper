package com.gabriel.desafioshopper.domain.repository

import com.gabriel.desafioshopper.data.model.ConfirmRideRequest
import com.gabriel.desafioshopper.data.model.ConfirmRideResponse

interface ConfirmRideRepository {

    suspend fun getConfirmRide(request: ConfirmRideRequest): ConfirmRideResponse
}