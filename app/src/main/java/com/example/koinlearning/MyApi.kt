package com.example.koinlearning

import retrofit2.http.GET

interface MyApi {

    @GET("my/endpoint")
    fun callApi()
}