package com.example.bouillon.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bouillon.R
import com.example.bouillon.model.users.UserRepository


class SignUpViewModel() : ViewModel() {


    val username = MutableLiveData<String>()

    val password = MutableLiveData<String>()

    val repassword = MutableLiveData<String>()


    private val _showToast = MutableLiveData<String>()
    val showToast: LiveData<String>
        get() = _showToast

    init {
        username.value = "nomUtilisateur@gmail.com"
        password.value = "********"
        repassword.value = "********"
    }

    fun signUp() {
        if (username.value.isNullOrEmpty() || password.value.isNullOrEmpty() || repassword.value.isNullOrEmpty()) {
            _showToast.postValue("errorIdMdpVoid")

        } else if (password.value != repassword.value) {

            _showToast.postValue("errorMdpNonIdentique")
        }
     else if (username.value.exist = true )
    {

        _showToast.postValue("errorIdExixt")
    }
        else if (username.value.exist = false && password.value == repassword.value)
        {

            // traitement
        }

}

}