package com.example.uts_160419051.util

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.example.uts_160419051.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import java.lang.Exception

fun ImageView.loadImageProfile(url: String, progressBar: ProgressBar) {
    Picasso.get()
        .load(url)
        .resize(400,400)
        .centerCrop()
        .error(R.drawable.ic_baseline_error_outline_24)
        .into(this, object :Callback {
            override fun onSuccess() {
                progressBar.visibility = View.GONE
            }

            override fun onError(e: Exception?) {

            }
        })
}