package com.gabriel.desafioshopper.data.repository

import com.gabriel.desafioshopper.data.api.ServiceApi
import com.gabriel.desafioshopper.data.model.ConfirmRideRequest
import com.gabriel.desafioshopper.data.model.ConfirmRideResponse
import com.gabriel.desafioshopper.domain.repository.ConfirmRideRepository
import javax.inject.Inject

class ConfirmRideRepositoryImpl @Inject constructor(
    private val serviceApi: ServiceApi
) : ConfirmRideRepository {
    override suspend fun getConfirmRide(request: ConfirmRideRequest): ConfirmRideResponse {
        return serviceApi.getConfirmRide(request)
    }
}