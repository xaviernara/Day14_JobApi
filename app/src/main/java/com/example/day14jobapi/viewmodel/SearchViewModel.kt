package com.example.day14jobapi.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.day14jobapi.model.JobResponse
import com.example.day14jobapi.repo.JobsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel : ViewModel() {

    private val _jobsResponse = MutableLiveData<JobResponse>()

    private val _description = MutableLiveData<String>()

    private val _type = MutableLiveData<Boolean>()

    private val _location = MutableLiveData<String>()


    val jobsResponse : LiveData<JobResponse>
        get() = _jobsResponse

    private val description : LiveData<String>
        get() = _description

    private val location : LiveData<String>
        get() = _location

    private val type : LiveData<Boolean>
        get() = _type


    init {
        val callback: Callback<JobResponse> = object : Callback<JobResponse> {
            /**
             * Invoked when a network exception occurred talking to the server or when an unexpected exception
             * occurred creating the request or processing the response.
             */
            override fun onFailure(call: Call<JobResponse>, t: Throwable) {
                Log.e("VM Callback Error:", "ON FAILURE", t)
            }

            /**
             * Invoked for a received HTTP response.
             *
             *
             * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
             * Call [Response.isSuccessful] to determine if the response indicates success.
             */
            override fun onResponse(call: Call<JobResponse>, response: Response<JobResponse>) {
                _jobsResponse.value = response.body()
            }
        }

        viewModelScope.launch(Dispatchers.Main){JobsRepo.jobService.getJobs(description,location,type)}

    }


        fun getJobs(description: String, location: String, type: Boolean ) {

            /*
        CoroutineScope tied to this ViewModel. This scope will be
        canceled when ViewModel will be cleared, i.e ViewModel.onCleared is called

        Launches a new coroutine without blocking the current thread and returns a reference to the coroutine as a Job.
        The coroutine is cancelled when the resulting job is cancelled.
        */

            viewModelScope.launch(Dispatchers.Main) {
                val jobs = JobsRepo.getJobs(description,location,type)
                _jobsResponse.value = jobs

            }
        }
    }
