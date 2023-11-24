package com.example.examen.domain

import com.example.examen.data.CovidRepository
import com.example.examen.data.network.models.Country

/**
 * Facilitates retrieval of COVID-19 data for a specific date.
 *
 * Acts as a mediator to access data from the `CovidRepository`.
 */
class CovidListRequirements {

	private val repository = CovidRepository()

	/**
	 * Retrieves COVID-19 data for a given date.
	 *
	 * @param date The date for which to retrieve COVID-19 data.
	 * @return A list of [Country] with COVID-19 data or null if no data is available.
	 */
	suspend operator fun invoke(date: String): List<Country>? = repository.getCovidDataByCountry(date)
}
