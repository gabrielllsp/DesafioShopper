package com.gabriel.desafioshopper.domain.repository

import com.gabriel.desafioshopper.data.model.TripHistoryResponse

interface TripHistoryRepository {
    suspend fun getTripHistory(customerId: String, driverId: Int? = null): TripHistoryResponse
}