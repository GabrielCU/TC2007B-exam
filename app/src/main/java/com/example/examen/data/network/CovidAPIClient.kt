package com.example.examen.data.network

import android.util.Log
import com.example.examen.data.network.models.CovidObject
import com.example.examen.utils.Constants

class CovidAPIClient {

	private lateinit var api: CovidAPIService

	suspend fun getCovidDataByCountry(country: String): CovidObject? {
		api = NetworkModuleDI() // Initialize API service

		return try {
			val response = api.getCovidDataByCountry(Constants.KEY, country)
			Log.d("API Response", response.toString())
			response
		} catch (e: Exception) {
			Log.e("API Error", e.toString())
			null
		}

	}
}
