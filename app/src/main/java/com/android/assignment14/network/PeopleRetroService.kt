package com.android.assignment14.network

import com.android.assignment14.models.PeopleRecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface PeopleRetroService {

    @GET("people")
    suspend fun getDataFromApi(@Query("page") query : String): PeopleRecyclerList
}