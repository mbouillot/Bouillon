package com.example.bouillon.API

import com.google.android.gms.common.api.Response
import retrofit2.http.GET

interface APIService {

    @GET("https://api.spoonacular.com/recipes/complexSearch?apiKey=635a0c7cd39a4a4cbafd0a1787c8e2ca")
    abstract fun getRecipe(): Response<List<ArrayJSONModel>>
}