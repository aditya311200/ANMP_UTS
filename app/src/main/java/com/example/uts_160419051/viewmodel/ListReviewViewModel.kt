package com.example.uts_160419051.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.uts_160419051.model.Review
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class ListReviewViewModel(application: Application):AndroidViewModel(application) {
    val reviewLD = MutableLiveData<List<Review>>()
    val loadingErrorLD = MutableLiveData<Boolean>()
    val loadingLD = MutableLiveData<Boolean>()

    private var TAG = "volleyTag"
    private var queue:RequestQueue ?= null

    fun refresh() {
        loadingErrorLD.value = false
        loadingLD.value = true

        queue = Volley.newRequestQueue(getApplication())
        var url = "https://ubaya.fun/hybrid/160419051/uts_anmp/daftarreview.json"

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                val sType = object : TypeToken<List<Review>>() {}.type
                val result = Gson().fromJson<List<Review>>(response, sType)

                reviewLD.value = result
                loadingLD.value = false
                Log.d("showvolley", response.toString())

            },
            {
                loadingLD.value = false
                loadingErrorLD.value = true
                Log.d("showvolley", it.toString())
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }

    override fun onCleared() {
        super.onCleared()
        queue?.cancelAll(TAG)
    }
}