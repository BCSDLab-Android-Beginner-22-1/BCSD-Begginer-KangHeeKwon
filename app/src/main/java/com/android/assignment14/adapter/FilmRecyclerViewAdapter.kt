package com.android.assignment14.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.android.assignment14.R
import com.android.assignment14.models.FilmRecyclerData


class FilmRecyclerViewAdapter : RecyclerView.Adapter<FilmRecyclerViewAdapter.MyViewHolder>(){

    var items = ArrayList<FilmRecyclerData>()

    fun setUpdatedData(items : ArrayList<FilmRecyclerData>) {
        this.items = items
        notifyDataSetChanged()
    }
    class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val mainText = view.findViewById<TextView>(R.id.mainText)
        val subText1 = view.findViewById<TextView>(R.id.subText1)
        val subText2 = view.findViewById<TextView>(R.id.subText2)

        fun bind(data : FilmRecyclerData) {
            mainText.text = data.title
            subText1.text = data.director
            subText2.text = data.release_date
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