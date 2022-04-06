package com.example.uts_160419051.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.uts_160419051.R
import com.example.uts_160419051.util.loadImageProfile
import com.example.uts_160419051.viewmodel.DetailKulinerViewModel
import kotlinx.android.synthetic.main.fragment_detail_kuliner.*

class DetailKulinerFragment : Fragment() {
    private lateinit var viewDetail:DetailKulinerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_kuliner, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(arguments != null) {
            val kulinerId = DetailKulinerFragmentArgs.fromBundle(requireArguments()).kulinerId

            viewDetail = ViewModelProvider(this).get(DetailKulinerViewModel::class.java)
            viewDetail.fetch(kulinerId)

            observeDetailViewModel()

            btnLihatReview.setOnClickListener {
                val action = DetailKulinerFragmentDirections.actionReviewListFragment()
                Navigation.findNavController(it).navigate(action)
            }

            btnTambahReview.setOnClickListener {
                val action = DetailKulinerFragmentDirections.actionAddReviewFragment()
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    fun observeDetailViewModel() {
        viewDetail.kulinerLD.observe(viewLifecycleOwner, {
            txtDetailNama.setText(it.nama)
            txtDetailDeskripsi.setText(it.deskripsi)
            txtDetailJamBuka.setText(it.jam_buka)
            txtDetailJamTutup.setText(it.jam_tutup)
            txtDetailRating.setText(it.rating)

            imgFoto.loadImageProfile(it.url.toString(), progressBarFoto)
        })
    }
}