package com.android.assignment14.network

import com.android.assignment14.models.FilmRecyclerList
import retrofit2.http.GET
import retrofit2.http.Query

interface FilmsRetroService {

    @GET("films")
    suspend fun getDataFromApi(@Query("page") query : String): FilmRecyclerList
}