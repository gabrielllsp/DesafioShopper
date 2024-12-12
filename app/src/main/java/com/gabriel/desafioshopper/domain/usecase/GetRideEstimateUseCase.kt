package com.gabriel.desafioshopper.domain.usecase

import com.gabriel.desafioshopper.data.mapper.toDomain
import com.gabriel.desafioshopper.data.model.EstimateRequest
import com.gabriel.desafioshopper.domain.model.RideEstimate
import com.gabriel.desafioshopper.domain.repository.RideRepository
import javax.inject.Inject

class GetRideEstimateUseCase @Inject constructor(
    private val rideRepository: RideRepository
) {
    suspend operator fun invoke(request: EstimateRequest): RideEstimate {
        return rideRepository.getRideEstimate(request).toDomain()
    }

//    suspend operator fun invoke(
//        customerId: String,
//        origin: String,
//        destination: String
//    ): RideEstimate {
//        return rideRepository.getRideEstimate(
//            customerId = customerId,
//            origin = origin,
//            destination = destination
//        ).toDomain()
//    }
}