package com.example.bouillon.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MenuViewModel {


    private val _navigation = MutableLiveData<Int>()
    val navigation: LiveData<Int>
        get() = _navigation

    fun search() {
        _navigation.postValue(1);
    }

    fun favorites() {
        _navigation.postValue(2);
    }
}