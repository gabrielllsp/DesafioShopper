package com.gabriel.desafioshopper.di

import com.gabriel.desafioshopper.data.api.ServiceApi
import com.gabriel.desafioshopper.network.ServiceProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun providesServiceProvider() = ServiceProvider()

    @Provides
    fun providesServiceApi(
        serviceProvider: ServiceProvider
    ): ServiceApi {
        return serviceProvider.createService(ServiceApi::class.java)
    }
}