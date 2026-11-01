package com.example.kotlin_mvvm_retrofit

import retrofit2.http.GET

interface ApiService {

    @GET("professions")
    suspend fun getData():MutableList<Data>


}