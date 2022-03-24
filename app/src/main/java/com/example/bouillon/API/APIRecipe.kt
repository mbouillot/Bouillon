package com.example.bouillon.API

import com.squareup.moshi.Json


class APIRecipe {

    data class ApiResult(
        @field:Json(name = "offset")
        var offset: Int,

        @field:Json(name = "number")
        var number: Int,

        @field:Json(name = "results")
        var results: List<AttributeRecipe>
    )

    data class JsonModel(
        //@field:Json(name = "results")
        var results: List<AttributeRecipe>?,

        //@field:Json(name = "offset")
        var offset: Int?,

        //@field:Json(name = "number")
        var number: Int?,

        //@field:Json(name = "totalResults")
        var totalResults: Int?,
    )
}