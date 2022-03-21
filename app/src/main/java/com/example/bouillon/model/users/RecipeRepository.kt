package com.example.bouillon.model.users

import android.util.Log
import com.example.bouillon.API.APIService
import com.squareup.moshi.Json
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RecipeRepository {

    @field:Json(name = "id")
    var idRecipe: Int?,

    @field:Json(name = "title")
    var titleRecipe: String?,

    @field:Json(name = "image")
    var imageRecipe: String?,

    @field:Json(name = "imageType")
    var imageTypeRecipe: String?


    fun parseJSON() {

        // Create Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.spoonacular.com/recipes/complexSearch?apiKey=635a0c7cd39a4a4cbafd0a1787c8e2ca")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        // Create Service
        val service = retrofit.create(APIService::class.java)
        CoroutineScope(Dispatchers.IO).launch {

            // Do the GET request and get response
            val response = service.getRecipe()

            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {

                    val items = response.body()
                    if (items != null) {
                        for (i in 0 until items.count()) {
                            // ID
                            val id = items[i].idRecipe ?: "N/A"
                            Log.d("ID: ", id)

                            // Employee Name
                            val titleRecipe = items[i].titleRecipe ?: "N/A"
                            Log.d("Title recipe: ", titleRecipe)

                            // Employee Salary
                            val imageRecipe = items[i].imageRecipe ?: "N/A"
                            Log.d("Image recipe: ", imageRecipe)

                            // Employee Age
                            val imageTypeRecipe = items[i].imageTypeRecipe ?: "N/A"
                            Log.d("Image type recipe: ", imageTypeRecipe)

                        }
                    }

                } else {

                    Log.e("RETROFIT_ERROR", response.code().toString())

                }
            }
        }
    }
}