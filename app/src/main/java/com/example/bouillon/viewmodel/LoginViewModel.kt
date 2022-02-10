package com.example.bouillon.viewmodel

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bouillon.model.users.UserRepository

class LoginViewModel(var context: Context) : ViewModel() {

    private val userRepository: UserRepository = UserRepository()

    private val _username = MutableLiveData<String>()
    val username: LiveData<String>
        get() = _username

    private val _password = MutableLiveData<String>()
    val password: LiveData<String>
        get() = _password

    init {
        _username.value = "totodu07@gmail.com"
        _password.value = "totodu07"

    }

    fun logIn() {
        if (_username.value.isNullOrEmpty() || _password.value.isNullOrEmpty()) {
            //  TODO: Erreur à gérer
        }
        else
        {
            _username.value?.let { username ->
                _password.value?.let { password ->
                    userRepository.logIn(username, password, closure = { result, exception -> Unit
                        if (exception != null) {
                            //  TODO: Display error
                            Toast.makeText(context,"Identifiant ou mot de passe incorrect", Toast.LENGTH_SHORT).show()

                        } else {
                            //  TODO: Login succeed, go to next page
                            Toast.makeText(context,"Connexion réussie", Toast.LENGTH_SHORT).show()

                        }
                    })
                }
            }
        }
    }

}
