package com.example.uts_160419051.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uts_160419051.R
import com.example.uts_160419051.viewmodel.ListReviewViewModel
import kotlinx.android.synthetic.main.fragment_review_list.*

class ReviewListFragment : Fragment() {
    private lateinit var viewModel:ListReviewViewModel
    private val reviewListAdapter = ReviewListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_review_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListReviewViewModel::class.java)
        viewModel.refresh()

        recViewReview.layoutManager = LinearLayoutManager(context)
        recViewReview.adapter = reviewListAdapter

        refreshLayoutReview.setOnRefreshListener {
            recViewReview.visibility = View.GONE
            txtErrorReview.visibility = View.GONE
            progressLoadReview.visibility = View.VISIBLE

            viewModel.refresh()

            refreshLayoutReview.isRefreshing = false
        }
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.reviewLD.observe(viewLifecycleOwner, {
            reviewListAdapter.updateReviewList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, {
            txtErrorReview.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, {
            if (it) {
               progressLoadReview.visibility = View.VISIBLE
               recViewReview.visibility =  View.GONE
            } else {
                progressLoadReview.visibility = View.GONE
                recViewReview.visibility = View.VISIBLE
            }
        })
    }
}