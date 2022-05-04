package com.example.koinlearning

class MainRepositoryImpl(
    private val api: MyApi
) : MainRepository {


    override fun doNetworkCall() {
        api.callApi()
    }
}