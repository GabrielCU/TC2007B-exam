package com.example.examen.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examen.data.network.models.Country
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
		viewModel.getCovidList("2021-12-07")
		
	}
	
	private fun initializeBinding() {
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
	}
	
	private fun initializeObservers() {
		viewModel.covidLiveData.observe(this) { countries: List<Country> -> 
			setUpRecyclerView(countries)
		}
	}

	private fun setUpRecyclerView(dataForList: List<Country>) {
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