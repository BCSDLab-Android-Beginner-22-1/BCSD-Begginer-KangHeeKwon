package com.android.assignment14.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.assignment14.models.FilmRecyclerList
import com.android.assignment14.network.RetroInstance
import com.android.assignment14.network.FilmsRetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FilmViewModel: ViewModel() {
    lateinit var recyclerListLiveData : MutableLiveData<FilmRecyclerList>

    init {
        recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclerListObserver(): MutableLiveData<FilmRecyclerList> {
        return recyclerListLiveData
    }

    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(FilmsRetroService::class.java)
            val response  = retroInstance.getDataFromApi("1")
            recyclerListLiveData.postValue(response)
        }
    }
}