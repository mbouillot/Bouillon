package com.example.bouillon.model.users

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class UserRepository() {

    private var auth: FirebaseAuth = Firebase.auth

    fun logIn(email: String, password: String, closure: (result: FirebaseUser?, exception: Exception?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    closure(user, null)
                } else {
                    closure(null, task.exception)
                }
            }
    }

    fun signUp(email: String, password: String, closure: (result: FirebaseUser?, exception: Exception?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    closure(user, null)
                } else {
                    closure(null, task.exception)
                }
            }
    }

}