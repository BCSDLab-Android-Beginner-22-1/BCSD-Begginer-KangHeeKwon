package com.android.assignment14.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetroInstance {

    companion object {
        val BaseURL = "https://swapi.dev/api/"

        fun getRetroInstance(): Retrofit {

            val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.MINUTES)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()

            val api = Retrofit.Builder()
                .baseUrl(BaseURL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return api
        }
    }
}