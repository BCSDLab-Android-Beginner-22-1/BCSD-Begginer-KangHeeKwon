package com.android.assignment14.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.assignment14.models.PlanetsRecyclerList
import com.android.assignment14.network.RetroInstance
import com.android.assignment14.network.PlanetsRetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlanetsViewModel: ViewModel() {
    lateinit var recyclerListLiveData : MutableLiveData<PlanetsRecyclerList>

    init {
        recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclerListObserver(): MutableLiveData<PlanetsRecyclerList> {
        return recyclerListLiveData
    }

    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(PlanetsRetroService::class.java)
            val response  = retroInstance.getDataFromApi("1")
            recyclerListLiveData.postValue(response)
        }
    }
}