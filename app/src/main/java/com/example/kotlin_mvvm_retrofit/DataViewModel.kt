package com.example.kotlin_mvvm_retrofit

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DataViewModel: ViewModel() {

    val d = MutableLiveData<MutableList<Data>?>()

    val error = MutableLiveData<String>()

    private val repo = Repo()

    fun getData(){
        viewModelScope.launch {
                try{
                    val l = repo.getData()
                    d.value = l
                    android.util.Log.d("API_TEST", "API call succeeded")
                }catch(e:Exception){
                    error.value = e.message?:"something went wrong"
                    android.util.Log.e("API_TEST", "API failed", e)
                }
        }
    }



}