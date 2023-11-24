package com.example.examen.framework.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.examen.R
import com.example.examen.data.network.models.Country
import com.example.examen.databinding.ActivityMainBinding
import com.example.examen.framework.adapters.CovidAdapter
import com.example.examen.framework.viewmodels.MainViewModel
import com.example.examen.utils.GridSpacingItemDecoration
import java.text.SimpleDateFormat
import android.widget.SearchView

import java.util.*

/**
 * Activity for displaying COVID-19 statistics.
 *
 * Manages UI components for displaying and interacting with COVID-19 data,
 * including a RecyclerView for the data, a CalendarView for selecting dates,
 * and a SearchView for filtering results.
 */
class MainActivity: AppCompatActivity() {

	private lateinit var binding: ActivityMainBinding
	private val adapter: CovidAdapter = CovidAdapter()
	private val viewModel: MainViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		initializeBinding()
		initializeObservers()
		initializeCalendarView()
		setUpSearchView()
		viewModel.getCovidList("2021-09-19")
	}

	/**
	 * Initializes the binding for the activity's views.
	 */
	private fun initializeBinding() {
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)

		val spacingInPixels = resources.getDimensionPixelSize(R.dimen.grid_layout_margin)
		binding.rvCovidList.addItemDecoration(GridSpacingItemDecoration(2, spacingInPixels, true))
	}

	/**
	 * Sets up observers for LiveData in the ViewModel.
	 */
	private fun initializeObservers() {
		viewModel.covidLiveData.observe(this) { countries: List<Country> ->
			adapter.setData(countries)
			setUpRecyclerView(countries)
		}
	}

	/**
	 * Sets up the RecyclerView with a GridLayoutManager and the CovidAdapter.
	 *
	 * @param dataForList The data to be displayed in the RecyclerView.
	 */
	private fun setUpRecyclerView(dataForList: List<Country>) {
		binding.rvCovidList.setHasFixedSize(true)

		val linearLayoutManager = GridLayoutManager(this, 2)
		binding.rvCovidList.layoutManager = linearLayoutManager
		binding.rvCovidList.adapter = adapter
	}

	/**
	 * Initializes the CalendarView and sets a date change listener to fetch data for the selected date.
	 */
	private fun initializeCalendarView() {
		val calendar = Calendar.getInstance()

		calendar.set(2021, Calendar.SEPTEMBER, 19)
		val specificDateMillis = calendar.timeInMillis

		binding.calendarView.date = specificDateMillis

		binding.calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
			val selectedDate = Calendar.getInstance()
			selectedDate.set(year, month, dayOfMonth)
			val formattedDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(selectedDate.time)
			viewModel.getCovidList(formattedDate)
		}
	}

	/**
	 * Sets up the SearchView for filtering the RecyclerView data.
	 */
	private fun setUpSearchView() {
		binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
			override fun onQueryTextSubmit(query: String?): Boolean {
				query?.let { adapter.filter.filter(it) }
				return false
			}

			override fun onQueryTextChange(newText: String?): Boolean {
				newText?.let { adapter.filter.filter(it) }
				return false
			}
		})
	}
}
