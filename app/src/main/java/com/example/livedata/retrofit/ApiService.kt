package com.example.livedata.retrofit

import com.example.livedata.models.MyCurrency
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("json")
    fun getAllData():Call<List<MyCurrency>>

}