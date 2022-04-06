package com.example.uts_160419051.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.uts_160419051.R
import com.example.uts_160419051.model.Review
import com.example.uts_160419051.util.loadImageProfile
import kotlinx.android.synthetic.main.review_list_item.view.*

class ReviewListAdapter(val reviewList:ArrayList<Review>):RecyclerView.Adapter<ReviewListAdapter.ReviewViewHolder>() {
    class ReviewViewHolder(val view: View):RecyclerView.ViewHolder(view)

    fun updateReviewList(newReviewList:List<Review>) {
        reviewList.clear()
        reviewList.addAll(newReviewList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.review_list_item, parent, false)

        return  ReviewViewHolder(v)
    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        holder.view.txtReviewNama.text = reviewList[position].nama
        holder.view.txtReviewIsi.text = reviewList[position].isi

        holder.view.imgViewReview.loadImageProfile(reviewList[position].url.toString(), holder.view.progressBarReview)
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }
}