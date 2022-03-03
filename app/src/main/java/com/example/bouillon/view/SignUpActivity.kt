package com.example.bouillon.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bouillon.R
import com.example.bouillon.viewmodel.LoginViewModel

class SignUpActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        viewModel.showToast.observe(this) { showToast ->
            if ( showToast == "errorVoid" ) {
                Toast.makeText(
                    this,
                    "L'un des champs est vide",
                    Toast.LENGTH_SHORT
                ).show()
            }
            if ( showToast == "errorMdpMdp" ) {
                Toast.makeText(
                    this,
                    "Les deux mots de passe ne sont pas similaire",
                    Toast.LENGTH_SHORT
                ).show()
            }
            if ( showToast == "succesInscription" ) {
                Toast.makeText(
                    this,
                    "Inscription réussi",
                    Toast.LENGTH_SHORT
                ).show()
            }
            if ( showToast == "errorImpossible" ) {
                Toast.makeText(
                    this,
                    "Inscription impossible veuillez vérifier vos champs",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
    }
}