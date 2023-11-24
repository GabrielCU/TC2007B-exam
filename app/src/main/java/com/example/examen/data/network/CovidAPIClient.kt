package com.example.examen.data.network

import NetworkModuleDI
import android.util.Log
import com.example.examen.data.network.models.Country
import com.example.examen.utils.Constants

/**
 * Covid API Client
 * @constructor Create empty Covid API Client
 */
class CovidAPIClient {

	private lateinit var api: CovidAPIService

	/**
	 * Get Covid data from API
	 * @param date
	 * @return List<Country>?
	 */
	suspend fun getCovidData(date: String): List<Country>? {
		api = NetworkModuleDI() // Initialize API service

		// Get data from API
		return try {
			val response = api.getCovidData(Constants.KEY, date)
			Log.d("API Response", response.toString())
			response.body()
		} catch (e: Exception) {
			Log.e("API Error", e.toString())
			null
		}

	}
}
