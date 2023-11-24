package com.example.examen.domain

import com.example.examen.data.CovidRepository
import com.example.examen.data.network.models.Country

class CovidListRequirements {
	
	private val repository = CovidRepository()
	
	suspend operator fun invoke(date: String): List<Country>? = repository.getCovidDataByCountry(date)
	
}