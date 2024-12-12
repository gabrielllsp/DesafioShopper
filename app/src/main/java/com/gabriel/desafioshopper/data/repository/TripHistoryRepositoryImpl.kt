package com.gabriel.desafioshopper.data.repository

import com.gabriel.desafioshopper.data.api.ServiceApi
import com.gabriel.desafioshopper.data.model.TripHistoryResponse
import com.gabriel.desafioshopper.domain.repository.TripHistoryRepository
import javax.inject.Inject

class TripHistoryRepositoryImpl @Inject constructor(
    private val serviceApi: ServiceApi
) : TripHistoryRepository {
    override suspend fun getTripHistory(customerId: String, driverId: Int?): TripHistoryResponse {
        return serviceApi.getTripHistory(
            customerId = customerId,
            driverId = driverId
        )
    }
}