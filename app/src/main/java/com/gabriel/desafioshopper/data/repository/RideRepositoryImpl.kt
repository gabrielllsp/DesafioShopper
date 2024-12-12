package com.gabriel.desafioshopper.data.repository

import com.gabriel.desafioshopper.data.api.ServiceApi
import com.gabriel.desafioshopper.data.model.EstimateRequest
import com.gabriel.desafioshopper.data.model.RideEstimateResponse
import com.gabriel.desafioshopper.domain.repository.RideRepository
import javax.inject.Inject

class RideRepositoryImpl @Inject constructor(
    private val serviceApi: ServiceApi
) : RideRepository {

    override suspend fun getRideEstimate(request: EstimateRequest): RideEstimateResponse {
        return serviceApi.getRideEstimate(request)
    }
}