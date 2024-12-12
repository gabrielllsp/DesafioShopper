package com.gabriel.desafioshopper.domain.usecase

import com.gabriel.desafioshopper.data.model.TripHistoryResponse
import com.gabriel.desafioshopper.domain.repository.TripHistoryRepository
import javax.inject.Inject

class GetTripHistoryUseCase @Inject constructor(
    private val tripHistoryRepository: TripHistoryRepository
) {
    suspend operator fun invoke(customerId: String, driverId: Int? = null): TripHistoryResponse {
        return tripHistoryRepository.getTripHistory(customerId, driverId)
    }
}