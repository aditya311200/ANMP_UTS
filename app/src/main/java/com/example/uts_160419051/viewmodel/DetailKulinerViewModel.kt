package com.example.uts_160419051.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.uts_160419051.model.Kuliner
import com.google.gson.Gson

class DetailKulinerViewModel(application: Application): AndroidViewModel(application){
    val kulinerLD = MutableLiveData<Kuliner>()

    private var TAG = "volleyTag"
    private var queue:RequestQueue ?= null

    fun fetch(kulinerId: String) {
        queue = Volley.newRequestQueue(getApplication())
        var url = "https://ubaya.fun/hybrid/160419051/uts_anmp/daftarkuliner.php?id=$kulinerId"

        val stringRequest = StringRequest(Request.Method.GET, url,
            { response ->
                val result = Gson().fromJson<Kuliner>(response, Kuliner::class.java)
                kulinerLD.value = result
                Log.d("showvolley", response.toString())
            },
            {
                Log.d("showvolley", it.toString())
            })
        stringRequest.tag = TAG
        queue?.add(stringRequest)
    }
}