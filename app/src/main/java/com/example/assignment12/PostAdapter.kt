package com.example.assignment12

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment12.databinding.ItemRecyclerBinding
import kotlinx.coroutines.NonDisposableHandle.parent
import java.text.SimpleDateFormat
import java.util.*


class PostAdapter(private var dataSet : List<PostData>): RecyclerView.Adapter<PostAdapter.PostViewHolder>(){

    class PostViewHolder(val binding: ItemRecyclerBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_recycler, viewGroup, false)
        return PostViewHolder(ItemRecyclerBinding.bind(view))
    }

    override fun onBindViewHolder(viewholder: PostViewHolder, position: Int) {
        val time = dataSet[position].time
        val dataFormat = SimpleDateFormat("hh:mm")
        viewholder.binding.textTitle.text = dataSet[position].title
        viewholder.binding.textContents.text = dataSet[position].content
        viewholder.binding.name.text = dataSet[position].name
        viewholder.binding.textTime.text = dataFormat.format(time)
        viewholder.itemView.setOnClickListener{
            itemClickListener.onItemClick(it, position)
        }

        viewholder.itemView.setOnLongClickListener{
            itemClickListener.onLongClick(it, position)
            return@setOnLongClickListener true
        }

    }

    interface OnItemClickListener{
        fun onItemClick(v:View, position: Int)
        fun onLongClick(v:View, position: Int)
    }

    fun setItemClickListener(onItemClickListener: OnItemClickListener){
        this.itemClickListener = onItemClickListener
    }
    private lateinit var itemClickListener : OnItemClickListener

    override fun getItemCount() = dataSet.size



    fun setData(postData : List<PostData>){
        dataSet = postData
        notifyDataSetChanged()
    }

}
