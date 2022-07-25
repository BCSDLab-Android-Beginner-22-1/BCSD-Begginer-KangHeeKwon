package com.android.assignment14.models

import com.google.gson.annotations.SerializedName

data class PlanetsRecyclerList(
    @SerializedName("results")
    val results: ArrayList<PlanetsRecyclerData>
)
data class PlanetsRecyclerData(val name : String, val gravity: String, val population: String)