package com.example.bouillon.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.bouillon.R
import com.example.bouillon.databinding.ActivityLoginBinding
import com.example.bouillon.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.*


class LoginActivity : AppCompatActivity() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var auth: FirebaseAuth
    lateinit var btnEnregistrer : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //initialisation
        btnEnregistrer = findViewById(R.id.btnEnregistrer)

        // creation de notre intent
        val monIntent : Intent =  Intent(this,SignUpActivity::class.java)

        //clic sur le bouton
        btnEnregistrer.setOnClickListener {
            startActivity(monIntent)
        }




        auth = Firebase.auth
        val viewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        viewModel.showToast.observe(this) { showToast ->
            if ( showToast == "errorIdMdp" ) {
                Toast.makeText(
                    this,
                    "L'identifiant ou le mot de passe n'est pas valide",
                    Toast.LENGTH_SHORT
                ).show()
            }
                if ( showToast == "errorIdMdpVoid" ) {
                    Toast.makeText(
                        this,
                        "L'identifiant ou le mot de passe n'est pas saisie",
                        Toast.LENGTH_SHORT
                    ).show()
            }
            if ( showToast == "succesConnexion" ) {
                Toast.makeText(
                    this,
                    "Connexion réussi",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }
        val binding: ActivityLoginBinding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
        //setupListeners();

    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser

    }


}