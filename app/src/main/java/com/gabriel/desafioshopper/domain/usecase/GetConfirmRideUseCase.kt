package com.gabriel.desafioshopper.domain.usecase

import com.gabriel.desafioshopper.data.mapper.toDomain
import com.gabriel.desafioshopper.data.model.ConfirmRideRequest
import com.gabriel.desafioshopper.domain.model.Confirm
import com.gabriel.desafioshopper.domain.repository.ConfirmRideRepository
import javax.inject.Inject

class GetConfirmRideUseCase @Inject constructor(
    private val repository: ConfirmRideRepository
) {
    suspend operator fun invoke(request: ConfirmRideRequest): Confirm {
        return repository.getConfirmRide(request).toDomain()
    }
}