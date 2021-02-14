package com.example.day14jobapi.remote

import android.app.job.JobService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 *              Kotlin Scope Operators
 *   .let {}  -> (perform operations) return type can be changed
 *   .also {} -> similar to .let but returns same type as calling item
 *   .apply {} -> allows you to make changes to the properties of the item
 *   .with {} -> look this up on your own :D
 *
 *
 *  val - runtime immutable - similar to a final in java
 *  const val - compile time immutable -
 *  var - mutable
 */
object RetrofitInstance {

    private const val BASE_URL = "https://jobs.github.com/"

    private val client = HttpLoggingInterceptor()
        .apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        .let { loginInterceptor ->
            OkHttpClient.Builder().addInterceptor(loginInterceptor).build()
        }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()


    val jobService: JobService by lazy { retrofit.create(JobService::class.java) }


}
