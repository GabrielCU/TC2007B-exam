package com.example.examen.data.network

import com.example.examen.data.network.models.Country
import com.example.examen.data.network.models.CovidResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Interface that defines the endpoints of the API
 */
interface CovidAPIService {
	
	/**
	 * Get the covid data of a specific date
	 * @param token the token to access the API
	 * @param date the date to get the data
	 * @return the response of the API
	 */
	@GET("covid19")
	suspend fun getCovidData(
		@Header("X-Api-Key") token: String,
		@Query("date") date: String
	): Response<List<Country>> 
}