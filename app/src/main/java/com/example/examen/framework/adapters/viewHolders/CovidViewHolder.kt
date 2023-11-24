package com.example.examen.framework.adapters.viewHolders

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.data.network.models.Country
import com.example.examen.databinding.ItemCovidCaseBinding

/**
 * ViewHolder for displaying COVID-19 data in a RecyclerView.
 *
 * Binds COVID-19 data to the view elements defined in `ItemCovidCaseBinding`.
 *
 * @param binding Instance of `ItemCovidCaseBinding` containing the layout for each item.
 */
class CovidViewHolder(private val binding: ItemCovidCaseBinding): RecyclerView.ViewHolder(binding.root) {

	/**
	 * Binds a [Country] object's data to the view.
	 *
	 * @param datedResult The [Country] object containing the COVID-19 data to be displayed.
	 */
	@SuppressLint("SetTextI18n")
	fun bind(datedResult: Country) {
		binding.tvCountry.text = datedResult.country
		binding.tvNewCases.text = "New cases: ${datedResult.cases.new}"
		binding.tvTotalCases.text = "Total cases: ${datedResult.cases.total}"
	}
}
