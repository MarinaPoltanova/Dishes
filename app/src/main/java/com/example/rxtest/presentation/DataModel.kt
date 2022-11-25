package com.example.rxtest.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class DataModel : ViewModel() {
    val cusineId: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
}