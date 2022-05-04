package com.example.koinlearning

import androidx.lifecycle.ViewModel

class MainViewModel(private val repository: MainRepository) : ViewModel(){


    fun doNetworkCall() {
//            repository.doNetworkCall()
        println("Print something")
    }
}