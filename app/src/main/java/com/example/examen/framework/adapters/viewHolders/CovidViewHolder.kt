package com.example.examen.framework.adapters.viewHolders

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.data.network.models.Country
import com.example.examen.databinding.ItemCovidCaseBinding

class CovidViewHolder(private val binding: ItemCovidCaseBinding): RecyclerView.ViewHolder(binding.root) {
	
	@SuppressLint("SetTextI18n")
	fun bind(datedResult: Country) {
		binding.tvCountry.text = datedResult.country
		binding.tvNewCases.text = "New cases: ${datedResult.cases.new}"
		binding.tvTotalCases.text = "Total cases: ${datedResult.cases.total}" 
	}
}