package com.gabriel.desafioshopper.domain.model


data class TripHistory(
    val customerId: String,
    val rides: List<Ride>
)