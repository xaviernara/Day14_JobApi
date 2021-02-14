package com.example.day14jobapi.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JobResponseItem(

    @field:Json(name ="company")
    val company: String,

    @field:Json(name ="company_logo")
    val company_logo: String,

    @field:Json(name ="company_url")
    val company_url: String,

    @field:Json(name ="created_at")
    val created_at: String,

    @field:Json(name ="description")
    val description: String,

    @field:Json(name ="how_to_apply")
    val how_to_apply: String,

    @field:Json(name ="id")
    val id: String,

    @field:Json(name ="location")
    val location: String,

    @field:Json(name ="title")
    val title: String,

    @field:Json(name ="type")
    val type: String,

    @field:Json(name ="url")
    val url: String
)