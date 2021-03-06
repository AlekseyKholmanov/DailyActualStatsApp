package com.example.dailyactualstats.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dailyactualstats.R
import com.example.dailyactualstats.ui.adapters.items.Spread

/**
 * @author Alexey Kholmanov (alexey.holmanov@cleverpumpkin.ru)
 */
class SpreadAdapter(
    private val items: MutableList<Spread> = mutableListOf(),
    val context: Context,
    private val countryClickListener: (String) -> Unit
) : RecyclerView.Adapter<SpreadHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpreadHolder {
        val viewType = LayoutInflater.from(context).inflate(R.layout.item_spread, parent, false)
        return SpreadHolder(viewType, countryClickListener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: SpreadHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(newItems:List<Spread>){
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}

class SpreadHolder(view: View, private val countryClickListener: (String) -> Unit) : RecyclerView.ViewHolder(view) {

    private val country: TextView = view.findViewById(R.id.country)
    private val infected: TextView = view.findViewById(R.id.death)

    fun bind(spread: Spread) {
        country.text = spread.country
        infected.text = spread.infected.toString()
        itemView.setOnClickListener {
            countryClickListener(spread.countryCode)
        }
    }
}

