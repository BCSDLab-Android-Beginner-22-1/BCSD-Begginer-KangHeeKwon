package com.android.assignment14.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.assignment14.models.PeopleRecyclerList
import com.android.assignment14.network.RetroInstance
import com.android.assignment14.network.PeopleRetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PeopleViewModel: ViewModel() {
    lateinit var recyclerListLiveData : MutableLiveData<PeopleRecyclerList>

    init {
        recyclerListLiveData = MutableLiveData()
    }

    fun getRecyclerListObserver(): MutableLiveData<PeopleRecyclerList> {
        return recyclerListLiveData
    }

    fun makeApiCall() {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(PeopleRetroService::class.java)
            val response  = retroInstance.getDataFromApi("1")
            recyclerListLiveData.postValue(response)
        }
    }
}