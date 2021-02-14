package com.example.day14jobapi.repo

import com.example.day14jobapi.model.JobResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface JobService {

    /**
     * Implementation using kotlin coroutines multithreading mechanism
     *
     * suspend is a keyword that lets the compiler know this is a coroutine function
     */

    // https://v2.jokeapi.dev/joke/any?amount=10
/*
    @Path(""): is used for url elements after the base url without ? before it
    ex: BASE_URL:https://v2.jokeapi.dev/joke/any,misc,xmas?amount=10

    @Path("category")

    @Get("") is used for url elements after the base url with ? before it
    @Get("amount")

 */
    @GET(" /positions.json")
    suspend fun getJobs(
        @Query(" description") description: String,@Query(" location") location: String,@Query("full_time") full_time:Boolean ): List<JobResponse>
}