package com.example.examen.data.network

import com.example.examen.data.network.models.Country
import com.example.examen.data.network.models.CovidResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface CovidAPIService {
	@GET("covid19")
	suspend fun getCovidData(
		@Header("X-Api-Key") token: String,
		@Query("date") date: String
	): Response<List<Country>> 
}