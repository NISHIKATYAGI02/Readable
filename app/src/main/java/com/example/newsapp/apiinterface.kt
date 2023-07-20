package com.example.newsapp

import retrofit2.Call
import retrofit2.http.GET

interface apiinterface {

    @GET("products") // end point of the link
    fun getProductDate() : Call<mydata>

}