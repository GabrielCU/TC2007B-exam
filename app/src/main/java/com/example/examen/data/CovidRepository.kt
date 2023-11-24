package com.example.examen.data

import com.example.examen.data.network.CovidAPIClient
import com.example.examen.data.network.models.Country

/**
 * Repository for fetching COVID-19 data.
 *
 * Provides functionality to retrieve COVID-19 data by country for a specific date.
 */
class CovidRepository {

	private val apiCovid = CovidAPIClient()

	/**
	 * Fetches COVID-19 data for a specified date.
	 *
	 * @param date The date for which COVID-19 data is requested.
	 * @return A list of [Country] data or null if no data is available.
	 */
	suspend fun getCovidDataByCountry(date: String): List<Country>? = apiCovid.getCovidData(date)
}
