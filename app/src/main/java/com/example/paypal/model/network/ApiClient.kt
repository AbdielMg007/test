package com.example.paypal.model.network

import com.example.paypal.model.enties.TrappistInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url


interface ApiClient {

    @GET
    fun getInfo(@Url url:String): Call<TrappistInfo>

}