package com.example.kotlin_mvvm_retrofit

class Repo {

    suspend fun getData():MutableList<Data>{
        return RetrofitInstance.api.getData()
    }

}