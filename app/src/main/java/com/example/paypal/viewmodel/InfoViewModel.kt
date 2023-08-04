package com.example.paypal.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.paypal.model.enties.TrappistInfo
import com.example.paypal.model.network.ApiDbClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoViewModel : ViewModel(){

    private val nasaApiService = ApiDbClient.service

    private val _trappistInfo = MutableLiveData<TrappistInfo>()

    val trappistInfo: LiveData<TrappistInfo> = _trappistInfo

    fun fetchTrappistInfo() {

        val call = nasaApiService.getInfo("paypal")

        call.enqueue(object : Callback<TrappistInfo> {
            override fun onResponse(call: Call<TrappistInfo>, response: Response<TrappistInfo>) {
                if (response.isSuccessful) {
                    _trappistInfo.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<TrappistInfo>, t: Throwable) {
                // Todo
            }
        })
    }

}

