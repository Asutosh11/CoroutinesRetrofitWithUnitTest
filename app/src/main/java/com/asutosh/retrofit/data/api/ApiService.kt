package com.asutosh.retrofit.data.api

import com.asutosh.retrofit.data.response.PersonalDetailsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("personalDetails.json")
    suspend fun getPersonalDetails(): Response<PersonalDetailsResponse>
}