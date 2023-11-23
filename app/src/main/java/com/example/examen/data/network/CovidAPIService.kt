package com.example.examen.data.network

import com.example.examen.data.network.models.CovidObject
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CovidAPIService {
	@GET("covid19")
	suspend fun getCovidDataByCountry(
		@Header("X-Api-Key") token: String,
		@Query("country") country: String
	): CovidObject	
}