package com.example.uts_160419051.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.uts_160419051.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment() {
   override fun onCreateView(
       inflater: LayoutInflater, container: ViewGroup?,
       savedInstanceState: Bundle?
   ): View? {
       // Inflate the layout for this fragment
       return inflater.inflate(R.layout.fragment_login, container, false)
   }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnLogin.setOnClickListener {
            val action = LoginFragmentDirections.actionKulinerListFragment()
            Navigation.findNavController(it).navigate(action)
        }

        btnMoveRegis.setOnClickListener {
            val action = LoginFragmentDirections.actionRegisterFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}