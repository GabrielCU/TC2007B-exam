package com.example.examen.framework.adapters.viewHolders

import androidx.recyclerview.widget.RecyclerView
import com.example.examen.data.network.models.DatedResult
import com.example.examen.data.network.models.Result
import com.example.examen.databinding.ItemCovidCaseBinding

class CovidViewHolder(private val binding: ItemCovidCaseBinding): RecyclerView.ViewHolder(binding.root) {
	
	fun bind(datedResult: DatedResult) {
		binding.tvNewCases.text = datedResult.result.new.toString()
		binding.tvTotalCases.text = datedResult.result.total.toString()
		binding.tvDate.text = datedResult.date
	}
}