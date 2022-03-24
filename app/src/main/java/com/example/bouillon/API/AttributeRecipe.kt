package com.example.bouillon.API

import com.squareup.moshi.Json

class AttributeRecipe (

    @field:Json(name = "id")
    var idRecipe: Int,

    @field:Json(name = "title")
    var titleRecipe: String,

    @field:Json(name = "image")
    var imageRecipe: String,

    @field:Json(name = "imageType")
    var imageTypeRecipe: String

)