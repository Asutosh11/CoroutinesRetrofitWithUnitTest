package com.asutosh.retrofit

import com.asutosh.retrofit.data.api.ApiService
import javax.inject.Inject

class MainRepository

@Inject  constructor(val apiService: ApiService){
    suspend fun getPersonalDetailsApi() = apiService.getPersonalDetails()
}