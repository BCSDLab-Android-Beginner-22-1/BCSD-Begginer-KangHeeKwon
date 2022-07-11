package com.example.assignment12


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){
    val postLiveData = MutableLiveData<List<PostData>>()
    private val data = arrayListOf<PostData>()

    fun addTask(post:PostData){
        data.add(post)
        postLiveData.value=data
    }

    fun deleteTask(position : Int){
        data.removeAt(position)
        postLiveData.value=data
    }

    fun modifyTask(post:PostData, position : Int){
        data.removeAt(position)
        data.add(post)
        postLiveData.value=data
    }
}