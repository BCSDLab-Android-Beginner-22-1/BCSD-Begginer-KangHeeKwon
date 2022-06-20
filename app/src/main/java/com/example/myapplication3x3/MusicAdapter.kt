package com.example.myapplication3x3

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*
import java.text.SimpleDateFormat

class MusicAdapter : RecyclerView.Adapter<Holder>() {

    val musicList = mutableListOf<Music>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return musicList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val music = musicList[position]
        holder.setMusic(music)
    }
}

class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
    var musicUri: Uri? = null

    fun setMusic(music:Music){
        musicUri = music.getMusicUri()
        itemView.imageAlbum.setImageURI(music.getAlbumUri())
        itemView.textArtist.text = music.artist
        itemView.textTitle.text = music.title
        val sdf = SimpleDateFormat("HH:mm:ss")
        itemView.textDuration.text = sdf.format(music.duration)

    }
}