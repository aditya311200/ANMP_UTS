package com.example.uts_160419051.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import com.example.uts_160419051.R
import com.example.uts_160419051.util.loadImageProfile
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val url: String = "https://randomuser.me/api/portraits/men/87.jpg"
        imgProfil.loadImageProfile(url,progressBarProfil)

        btnGantiPass.setOnClickListener {
            val action = ProfileFragmentDirections.actionChangePasswordFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}