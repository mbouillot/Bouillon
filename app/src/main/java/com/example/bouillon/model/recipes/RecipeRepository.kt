package com.example.bouillon.model.recipes

import android.util.Log
import com.example.bouillon.API.APIService
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RecipeRepository {

    fun search(title: String, closure: (result: List<Recipe>?, exception: Exception?) -> Unit) {

        // Create Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        // Create Service
        val service = retrofit.create(APIService::class.java)
        CoroutineScope(Dispatchers.IO).launch {

            // Do the GET request and get response
            val response = service.complexSearch("635a0c7cd39a4a4cbafd0a1787c8e2ca", title)

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val result = mutableListOf<Recipe>()

                    val items = response.body()
                    if (items != null) {
                        for (i in 0 until items.results.count()) {
                            // ID
                            val id = items.results[i].idRecipe
                            Log.d("ID: ", id.toString())

                            // Employee Name
                            val titleRecipe = items.results[i].titleRecipe
                            Log.d("Title recipe: ", titleRecipe)

                            // Employee Salary
                            val imageRecipe = items.results[i].imageRecipe
                            Log.d("Image recipe: ", imageRecipe)

                            // Employee Age
                            val imageTypeRecipe = items.results[i].imageTypeRecipe
                            Log.d("Image type recipe: ", imageTypeRecipe)

                            val newRecipe = Recipe(id, titleRecipe,imageRecipe,imageTypeRecipe)

                            result.add(newRecipe)

                        }

                        closure(result, null)

                    }

                } else {

                    Log.e("RETROFIT_ERROR", response.code().toString())

                    closure(null, Exception("Oops!"))

                }
            }
        }


    }
}