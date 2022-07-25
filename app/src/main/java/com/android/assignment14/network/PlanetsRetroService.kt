package com.android.assignment14.network

import com.android.assignment14.models.PlanetsRecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface PlanetsRetroService {

    @GET("planets")
    suspend fun getDataFromApi(@Query("page") query : String): PlanetsRecyclerList
}