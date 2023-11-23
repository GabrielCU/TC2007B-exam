package com.example.examen.framework.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.examen.data.network.models.Result
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.data.network.models.CovidObject
import com.example.examen.data.network.models.DatedResult
import com.example.examen.databinding.ItemCovidCaseBinding
import com.example.examen.framework.adapters.viewHolders.CovidViewHolder

class CovidAdapter(): RecyclerView.Adapter<CovidViewHolder>() {
	
	
	var data: List<DatedResult> = ArrayList()
	lateinit var context: Context
	
	@SuppressLint("NotConstructor")
	fun CovidAdapter(basicData: List<DatedResult>, context: Context) {
		this.data = basicData
		this.context = context
	}

	override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
		val item = data[position]
		holder.bind(item)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
		val binding = ItemCovidCaseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return CovidViewHolder(binding)
	}

	fun updateData(newData: List<DatedResult>) {
		data = newData
		notifyDataSetChanged()
	}

	override fun getItemCount() = data.size
}