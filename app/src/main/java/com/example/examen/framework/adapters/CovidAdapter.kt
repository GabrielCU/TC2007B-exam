package com.example.examen.framework.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.data.network.models.Country
import com.example.examen.databinding.ItemCovidCaseBinding
import com.example.examen.framework.adapters.viewHolders.CovidViewHolder
import java.util.*
import kotlin.collections.ArrayList

/**
 * Adapter for a RecyclerView to display COVID-19 data.
 *
 * Supports filtering of the displayed data based on country names.
 *
 * @param originalData Initial list of [Country] objects to be displayed.
 */
class CovidAdapter(private var originalData: List<Country> = ArrayList()): RecyclerView.Adapter<CovidViewHolder>(), Filterable {

	private var filteredList: List<Country> = originalData

	lateinit var context: Context

	override fun onBindViewHolder(holder: CovidViewHolder, position: Int) {
		val item = filteredList[position]
		holder.bind(item)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidViewHolder {
		val binding = ItemCovidCaseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
		return CovidViewHolder(binding)
	}

	override fun getItemCount() = filteredList.size

	/**
	 * Updates the data displayed by the adapter.
	 *
	 * @param newData The new list of [Country] objects to display.
	 */
	fun setData(newData: List<Country>) {
		this.originalData = newData
		this.filteredList = newData
		notifyDataSetChanged()
	}

	override fun getFilter(): Filter {
		return object : Filter() {
			override fun performFiltering(constraint: CharSequence?): FilterResults {
				val charString = constraint.toString()
				filteredList = if (charString.isEmpty()) {
					originalData
				} else {
					val filteredList = originalData.filter {
						it.country.lowercase(Locale.ROOT).contains(charString.toLowerCase(Locale.ROOT))
					}
					filteredList
				}
				val filterResults = FilterResults()
				filterResults.values = filteredList
				return filterResults
			}

			override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
				filteredList = results?.values as List<Country>
				notifyDataSetChanged()
			}
		}
	}
}
