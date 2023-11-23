package com.example.examen.framework.views

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examen.data.network.models.CovidObject
import com.example.examen.data.network.models.DatedResult
import com.example.examen.data.network.models.Result
import com.example.examen.databinding.ActivityMainBinding
import com.example.examen.framework.adapters.CovidAdapter
import com.example.examen.framework.viewmodels.MainViewModel

class MainActivity: AppCompatActivity() {
	
	private lateinit var binding: ActivityMainBinding
	private val adapter: CovidAdapter = CovidAdapter()
	private val viewModel: MainViewModel by viewModels()
	
	override fun onCreate(savedInstanceState: Bundle?) {
		
		super.onCreate(savedInstanceState)
		
		initializeBinding()
		initializeObservers()
		viewModel.getCovidList()
		
	}
	
	private fun initializeBinding() {
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
	}
	
	private fun initializeObservers() {
		viewModel.covidLiveData.observe(this) { datedResultList -> 
			setUpRecyclerView(datedResultList)
		}
	}

	private fun setUpRecyclerView(dataForList: List<DatedResult>) {
		binding.rvCovidList.setHasFixedSize(true)

		val linearLayoutManager = LinearLayoutManager(
			this,
			LinearLayoutManager.VERTICAL,
			false
		)

		binding.rvCovidList.layoutManager = linearLayoutManager
		adapter.CovidAdapter(dataForList, this)
		binding.rvCovidList.adapter = adapter
	}	
	
	
}