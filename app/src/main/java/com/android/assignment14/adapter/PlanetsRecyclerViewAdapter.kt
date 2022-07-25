package com.android.assignment14.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.assignment14.R
import com.android.assignment14.models.PlanetsRecyclerData


class PlanetsRecyclerViewAdapter : RecyclerView.Adapter<PlanetsRecyclerViewAdapter.MyViewHolder>(){

    var items = ArrayList<PlanetsRecyclerData>()

    fun setUpdatedData(items : ArrayList<PlanetsRecyclerData>) {
        this.items = items
        notifyDataSetChanged()
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val mainText = view.findViewById<TextView>(R.id.mainText)
        val subText1 = view.findViewById<TextView>(R.id.subText1)
        val subText2 = view.findViewById<TextView>(R.id.subText2)

        fun bind(data : PlanetsRecyclerData) {
            mainText.text = data.name
            subText1.text = data.gravity
            subText2.text = data.population
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_row, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      holder.bind(items.get(position))
    }
}