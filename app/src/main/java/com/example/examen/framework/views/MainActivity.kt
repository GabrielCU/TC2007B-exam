package com.example.examen.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.examen.R
import com.example.examen.data.network.models.Country
import com.example.examen.databinding.ActivityMainBinding
import com.example.examen.framework.adapters.CovidAdapter
import com.example.examen.framework.viewmodels.MainViewModel
import com.example.examen.utils.GridSpacingItemDecoration

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

		val linearLayoutManager = GridLayoutManager(this, 2)
		val spacingInPixels = resources.getDimensionPixelSize(R.dimen.grid_layout_margin)
		binding.rvCovidList.addItemDecoration(GridSpacingItemDecoration(2, spacingInPixels, true))
		binding.rvCovidList.layoutManager = linearLayoutManager
		adapter.CovidAdapter(dataForList, this)
		binding.rvCovidList.adapter = adapter
	}	
	
	
}