package com.example.examen.domain

import com.example.examen.data.CovidRepository
import com.example.examen.data.network.models.CovidObject

class CovidListRequirements {
	
	private val repository = CovidRepository()
	
	suspend operator fun invoke(): CovidObject? = repository.getCovidDataByCountry("Mexico")
	
}