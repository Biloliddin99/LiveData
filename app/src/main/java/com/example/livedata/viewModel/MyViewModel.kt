package com.example.livedata.viewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.livedata.models.MyCurrency
import com.example.livedata.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "MyViewModel"

class MyViewModel:ViewModel() {

    private val liveData = MutableLiveData<ArrayList<MyCurrency>>()
    fun getAllData():MutableLiveData<ArrayList<MyCurrency>> {

        ApiClient.getApiService().getAllData()
            .enqueue(object : Callback<List<MyCurrency>> {
                override fun onResponse(
                    call: Call<List<MyCurrency>>,
                    response: Response<List<MyCurrency>>
                ) {
                    if (response.isSuccessful) {
                        liveData.postValue(response.body() as ArrayList<MyCurrency>?)

                    }
                }

                override fun onFailure(call: Call<List<MyCurrency>>, t: Throwable) {
                    Log.d(TAG, "onFailure: ${t.message}")
                }
            })
        return liveData
    }
}