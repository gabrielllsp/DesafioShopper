package com.gabriel.desafioshopper.data.mapper

import com.gabriel.desafioshopper.data.model.ConfirmRideRequest
import com.gabriel.desafioshopper.data.model.ConfirmRideResponse
import com.gabriel.desafioshopper.data.model.DestinationResponse
import com.gabriel.desafioshopper.data.model.DriverRequest
import com.gabriel.desafioshopper.data.model.EstimateRequest
import com.gabriel.desafioshopper.data.model.OriginResponse
import com.gabriel.desafioshopper.data.model.ReviewResponse
import com.gabriel.desafioshopper.data.model.RideEstimateResponse
import com.gabriel.desafioshopper.data.model.RideOptionResponse
import com.gabriel.desafioshopper.data.model.RideResponse
import com.gabriel.desafioshopper.data.model.TripHistoryResponse
import com.gabriel.desafioshopper.domain.model.Confirm
import com.gabriel.desafioshopper.domain.model.ConfirmRide
import com.gabriel.desafioshopper.domain.model.Destination
import com.gabriel.desafioshopper.domain.model.Driver
import com.gabriel.desafioshopper.domain.model.Estimate
import com.gabriel.desafioshopper.domain.model.Origin
import com.gabriel.desafioshopper.domain.model.Review
import com.gabriel.desafioshopper.domain.model.Ride
import com.gabriel.desafioshopper.domain.model.RideEstimate
import com.gabriel.desafioshopper.domain.model.RideOption
import com.gabriel.desafioshopper.domain.model.TripHistory


fun EstimateRequest.toDomain(): Estimate {
    return Estimate(
        customerId = this.customerId,
        origin = this.origin,
        destination = this.destination
    )
}

fun OriginResponse.toDomain(): Origin {
    return Origin(
        latitude = latitude,
        longitude = longitude
    )
}

fun DestinationResponse.toDomain(): Destination {
    return Destination(
        latitude = latitude,
        longitude = longitude
    )
}

fun ReviewResponse.toDomain(): Review {
    return Review(
        rating = rating,
        comment = comment
    )
}

fun RideEstimateResponse.toDomain(): RideEstimate {
    return RideEstimate(
        origin = origin.toDomain(),
        destination = destination.toDomain(),
        distance = distance,
        duration = duration,
        options = this.options.map { it.toDomain() },
    )
}

fun RideOptionResponse.toDomain(): RideOption {
    return RideOption(
        id = id,
        description = description,
        name = name,
        vehicle = vehicle,
        reviewResponse = reviewResponse.toDomain(),
        value = value
    )
}

fun ConfirmRideResponse.toDomain(): Confirm {
    return Confirm(
        success = success
    )
}

fun ConfirmRideRequest.toDomain(): ConfirmRide {
    return ConfirmRide(
        customerId = customerId,
        destination = destination,
        distance = distance,
        driver = driver,
        duration = duration,
        origin = origin,
        value = value,
    )
}

fun DriverRequest.toDomain(): Driver {
    return Driver(
        id = id,
        name = name
    )
}

fun TripHistoryResponse.toDomain(): TripHistory {
    return TripHistory(
        customerId = customerId,
        rides = this.rides
    )
}

fun RideResponse.toDomain(): Ride {
    return Ride(
        date = date,
        destination = destination,
        distance = distance,
        driver = driver,
        duration = duration,
        id = id,
        origin = origin,
        value = value
    )
}

