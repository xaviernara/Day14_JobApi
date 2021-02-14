package com.example.day14jobapi.repo

import com.example.day14jobapi.model.JobResponse
import com.example.day14jobapi.remote.RetrofitInstance

object JobsRepo {

    val jobService : RetrofitInstance.jobService

    suspend fun getJobs (description: String, location: String, full_time:Boolean) : List<JobResponse> {
        return RetrofitInstance.jobService.getJobs(description,location,full_time)
    }
}