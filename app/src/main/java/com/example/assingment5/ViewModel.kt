package com.jwsoft.kotlinproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel : ViewModel() {

    var mainText: MutableLiveData<String> = MutableLiveData()

}