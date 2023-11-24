package com.example.examen.framework.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen.data.network.models.Country
import com.example.examen.domain.CovidListRequirements
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * ViewModel for managing and providing COVID-19 data to the UI.
 *
 * Holds live data of COVID-19 statistics which can be observed by the UI components.
 */
class MainViewModel: ViewModel() {

	val covidLiveData = MutableLiveData<List<Country>>()

	private val covidListRequirement = CovidListRequirements()

	/**
	 * Fetches and updates the live data with COVID-19 statistics for a specific date.
	 *
	 * @param date The date for which COVID-19 data is requested.
	 */
	fun getCovidList(date: String) {
		viewModelScope.launch(Dispatchers.IO) {
			val result: List<Country>? = covidListRequirement(date)
			result?.let {
				covidLiveData.postValue(it)
			}
		}
	}
}
