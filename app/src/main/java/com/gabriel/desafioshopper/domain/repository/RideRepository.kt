package com.gabriel.desafioshopper.domain.repository

import com.gabriel.desafioshopper.data.model.EstimateRequest
import com.gabriel.desafioshopper.data.model.RideEstimateResponse

interface RideRepository {

    suspend fun getRideEstimate(request: EstimateRequest): RideEstimateResponse
}