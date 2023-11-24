package com.example.examen.framework.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen.data.network.models.Country
import com.example.examen.domain.CovidListRequirements
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
	
	val covidLiveData = MutableLiveData<List<Country>>()
	
	private val covidListRequirement = CovidListRequirements()

	fun getCovidList(date: String) {
		viewModelScope.launch(Dispatchers.IO) {
			val result: List<Country>? = covidListRequirement(date)
			result?.let {
				covidLiveData.postValue(it)
			}
		}
	}
}