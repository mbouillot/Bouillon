package com.example.bouillon.API

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

   @GET("/recipes/complexSearch")
   fun complexSearch(@Query("apiKey") apiKey : String): Response<APIRecipe.ApiResult>

}