package com.example.bouillon.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.bouillon.R
import com.example.bouillon.databinding.ActivitySignUpBinding
import com.example.bouillon.view.menu.MenuActivity
import com.example.bouillon.viewmodel.SignUpViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity : AppCompatActivity() {

    private lateinit var viewModel: SignUpViewModel
    private lateinit var signUp: FirebaseAuth




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        signUp = Firebase.auth
        viewModel = ViewModelProviders.of(this).get(SignUpViewModel::class.java)
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
            if ( showToast == "errorShort" ) {
                Toast.makeText(
                    this,
                    "Le mot de passe doit contenir au moins 6 caractères",
                    Toast.LENGTH_SHORT
                ).show()
            }


        }

        viewModel.navigation.observe(this) { number ->
            var monIntent : Intent? = null
            if (number == 1)
            {
                monIntent =  Intent(this, MenuActivity::class.java)

            }

            monIntent?.let {
                startActivity(it)
            }
        }

        val binding: ActivitySignUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    public override fun onStart() {
        super.onStart()
        // Check if user is signed up (non-null) and update UI accordingly.
        val currentUser = signUp.currentUser

    }
}