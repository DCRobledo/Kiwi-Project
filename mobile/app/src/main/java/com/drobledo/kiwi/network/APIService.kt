package com.drobledo.kiwi.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

object RetrofitClient {
    private const val BASE_URL = "http://10.0.2.2:8080/api/" // Adjust to match your backend URL

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()) // Gson converter for parsing responses
        .build()

    val apiService: APIService = retrofit.create(APIService::class.java)
}

interface APIService {
    @GET("jobs") // Adjust based on your backend API endpoint
    suspend fun getJobs(): List<Job>

    @POST("jobs")
    suspend fun createJob(@Body job: Job): Job
}

data class Job(
    val id: Int,
    val title: String,
    val company: String
)
