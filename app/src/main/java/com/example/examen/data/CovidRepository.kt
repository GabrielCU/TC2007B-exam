package com.example.examen.data

import com.example.examen.data.network.CovidAPIClient
import com.example.examen.data.network.models.Country

class CovidRepository {
	
	private val apiCovid = CovidAPIClient()
	suspend fun getCovidDataByCountry(date: String): List<Country>? = apiCovid.getCovidData(date)
}