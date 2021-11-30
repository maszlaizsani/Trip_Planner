package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface APIservice {
    @GET("/flights/airports/icao/LHBP/2021-10-04T20:00/2021-10-05T08:00?withLeg=true&withCancelled=true&withCodeshared=true&withCargo=true&withPrivate=true&withLocation=false")
    fun fetchFlights(): Call<List<flights>>

}