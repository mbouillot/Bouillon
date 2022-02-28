package com.example.bouillon.viewmodel

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bouillon.model.users.UserRepository


class LoginViewModel() : ViewModel() {

    private val userRepository: UserRepository = UserRepository()

    val username = MutableLiveData<String>()

    val password = MutableLiveData<String>()


    private val _showToast = MutableLiveData<String>()
    val showToast: LiveData<String>
        get() = _showToast

    init {
        username.value = "totodu07@gmail.com"
        password.value = "totodu07"
    }

    fun logIn() {
        if (username.value.isNullOrEmpty() || password.value.isNullOrEmpty()) {
            //  TODO: Erreur à gérer
            _showToast.postValue("errorIdMdpVoid")

        }
        else
        {
            username.value?.let { username ->
                password.value?.let { password ->
                    userRepository.logIn(username, password, closure = {result, exception -> Unit
                        if (exception != null) {
                            //  TODO: Display error
                            _showToast.postValue("errorIdMdp")

                        } else {
                            //  TODO: Login succeed, go to next page
                            _showToast.postValue("succesConnexion")

                        }
                    })
                }
            }
        }
    }

    fun signUp() {

    }




}
