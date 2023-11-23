package com.example.examen.data

import com.example.examen.data.network.CovidAPIClient
import com.example.examen.data.network.models.CovidObject

class CovidRepository {
	
	private val apiCovid = CovidAPIClient()
	suspend fun getCovidDataByCountry(country: String): CovidObject? = apiCovid.getCovidDataByCountry("Mexico")
	
}