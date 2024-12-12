package com.gabriel.desafioshopper.di


import com.gabriel.desafioshopper.data.repository.ConfirmRideRepositoryImpl
import com.gabriel.desafioshopper.data.repository.RideRepositoryImpl
import com.gabriel.desafioshopper.data.repository.TripHistoryRepositoryImpl
import com.gabriel.desafioshopper.domain.repository.ConfirmRideRepository
import com.gabriel.desafioshopper.domain.repository.RideRepository
import com.gabriel.desafioshopper.domain.repository.TripHistoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindsRideRepositoryImpl(
        rideRepositoryImpl: RideRepositoryImpl
    ): RideRepository

    @Binds
    abstract fun bindsConfirmRideRepositoryImpl(
        confirmRideRepositoryImpl: ConfirmRideRepositoryImpl
    ): ConfirmRideRepository

    @Binds
    abstract fun bindsTripHistoryRepositoryImpl(
        tripHistoryRepositoryImpl: TripHistoryRepositoryImpl
    ): TripHistoryRepository
}