package com.gabriel.desafioshopper.data.api

import com.gabriel.desafioshopper.data.model.ConfirmRideRequest
import com.gabriel.desafioshopper.data.model.ConfirmRideResponse
import com.gabriel.desafioshopper.data.model.EstimateRequest
import com.gabriel.desafioshopper.data.model.RideEstimateResponse
import com.gabriel.desafioshopper.data.model.TripHistoryResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApi {

    @POST("ride/estimate")
    suspend fun getRideEstimate(
        @Body request: EstimateRequest
    ): RideEstimateResponse

    @PATCH("ride/confirm")
    suspend fun getConfirmRide(
        @Body request: ConfirmRideRequest
    ): ConfirmRideResponse

    @GET("ride/{customer_id}")
    suspend fun getTripHistory(
        @Path("customer_id") customerId: String,
        @Query("driver_id") driverId: Int? = null
    ): TripHistoryResponse
}