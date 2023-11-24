package com.example.examen.data.network

import NetworkModuleDI
import android.util.Log
import com.example.examen.data.network.models.Country
import com.example.examen.utils.Constants

class CovidAPIClient {

	private lateinit var api: CovidAPIService

	suspend fun getCovidData(date: String): List<Country>? {
		api = NetworkModuleDI() // Initialize API service

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
