package com.example.bouillon.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bouillon.R
import com.example.bouillon.model.users.UserRepository


class SignUpViewModel() : ViewModel() {

    private val userRepository: UserRepository = UserRepository()


    val username = MutableLiveData<String>()

    val password = MutableLiveData<String>()

    val repassword = MutableLiveData<String>()


    private val _showToast = MutableLiveData<String>()
    val showToast: LiveData<String>
        get() = _showToast

    private val _navigation = MutableLiveData<Int>()
    val navigation: LiveData<Int>
        get() = _navigation

    init {
        username.value = "xxxxxx@gmail.com"
        password.value = ""
        repassword.value = ""
    }

    fun signUp() {
        if (username.value.isNullOrEmpty() || password.value.isNullOrEmpty() || repassword.value.isNullOrEmpty()) {
            _showToast.postValue("errorVoid")

        } else if (password.value != repassword.value) {

            _showToast.postValue("errorMDPMDP")
        }
        else if (password.value!!.length <=6  || repassword.value!!.length <= 6 ) {

            _showToast.postValue("errorShort")
        }
        else
        {
            username.value?.let { username ->
                password.value?.let { password ->
                    userRepository.signUp(username, password, closure = {result, exception -> Unit
                        if (exception != null) {
                            //  TODO: Display error
                            _showToast.postValue("errorWarning")

                        } else {
                            //  TODO: Login succeed, go to next page
                            _showToast.postValue("succesInscription")
                            _navigation.postValue(1);


                        }
                    })
                }
            }
        }

}

}