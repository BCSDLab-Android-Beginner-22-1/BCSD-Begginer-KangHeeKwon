package com.android.assignment14.models

import com.google.gson.annotations.SerializedName

data class PeopleRecyclerList(
    @SerializedName("results")
    val results: ArrayList<PeopleRecyclerData>
)
data class PeopleRecyclerData(val name : String, val birth_year: String, val gender: String)