package com.example.bouillon.API

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

   @GET("/recipes/complexSearch")
   suspend fun complexSearch(@Query("apiKey") apiKey: String, @Query("query") query: String): Response<APIRecipe.ApiResult>

}