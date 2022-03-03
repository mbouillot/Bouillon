package com.example.bouillon.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FavoritesViewModel {
    private val _navigation = MutableLiveData<Int>()
    val navigation: LiveData<Int>
        get() = _navigation


}