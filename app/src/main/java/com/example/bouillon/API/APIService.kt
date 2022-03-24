package com.example.bouillon.API

import retrofit2.Response
import retrofit2.http.GET

interface APIService {

   @GET("/recipes/complexSearch?apiKey=635a0c7cd39a4a4cbafd0a1787c8e2ca")
   fun complexSearch(): Response<APIRecipe.ApiResult>

}