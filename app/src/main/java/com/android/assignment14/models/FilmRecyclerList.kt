package com.android.assignment14.models

import com.google.gson.annotations.SerializedName

data class FilmRecyclerList(
    @SerializedName("results")
    val results: ArrayList<FilmRecyclerData>
)
data class FilmRecyclerData(val title : String, val director: String, val release_date: String)