package com.example.examen.framework.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.examen.data.network.models.CovidObject
import com.example.examen.data.network.models.DatedResult
import com.example.examen.domain.CovidListRequirements
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
	
	val covidLiveData = MutableLiveData<List<DatedResult>>()
	
	private val covidListRequirement = CovidListRequirements()

	fun getCovidList() {
		viewModelScope.launch(Dispatchers.IO) {
			val result: CovidObject? = covidListRequirement()
			result?.let {
				val datedResultList = convertToDatedResultList(it)
				covidLiveData.postValue(datedResultList)
			}
		}
	}

	fun convertToDatedResultList(covidObject: CovidObject): List<DatedResult> {
		return covidObject.cases.map { (date, result) ->
			DatedResult(date, result)
		}
	}


}