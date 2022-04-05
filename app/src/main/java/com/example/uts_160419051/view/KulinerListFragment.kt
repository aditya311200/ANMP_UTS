package com.example.uts_160419051.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uts_160419051.R
import com.example.uts_160419051.viewmodel.ListKulinerViewModel
import kotlinx.android.synthetic.main.fragment_kuliner_list.*

class KulinerListFragment : Fragment() {
    private lateinit var viewModel:ListKulinerViewModel
    private val kulinerListAdapter = KulinerListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_kuliner_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ListKulinerViewModel::class.java)
        viewModel.refresh()

        recViewKuliner.layoutManager = LinearLayoutManager(context)
        recViewKuliner.adapter = kulinerListAdapter

        refreshLayoutKuliner.setOnRefreshListener {
            recViewKuliner.visibility = View.GONE
            txtErrorKuliner.visibility = View.GONE
            progressLoadKuliner.visibility = View.VISIBLE

            viewModel.refresh()

            refreshLayoutKuliner.isRefreshing = false
        }
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.kulinerLD.observe(viewLifecycleOwner, {
            kulinerListAdapter.updateKulinerList(it)
        })

        viewModel.loadingErrorLD.observe(viewLifecycleOwner, {
            txtErrorKuliner.visibility = if (it) View.VISIBLE else View.GONE
        })

        viewModel.loadingLD.observe(viewLifecycleOwner, {
            if (it) {
                progressLoadKuliner.visibility = View.VISIBLE
                recViewKuliner.visibility = View.GONE
            } else {
                progressLoadKuliner.visibility = View.GONE
                recViewKuliner.visibility = View.VISIBLE
            }
        })
    }
}