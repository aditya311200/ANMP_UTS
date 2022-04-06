package com.example.uts_160419051.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.uts_160419051.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.zip.Inflater

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = (supportFragmentManager.findFragmentById(R.id.hostFragment) as NavHostFragment).navController

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.itemLogout,
                R.id.itemProfil,
                R.id.registerFragment
            )
        )

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)
        NavigationUI.setupWithNavController(navView, navController)

        setupActionBarWithNavController(navController!!, appBarConfiguration!!)

        bottomNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.itemHome -> showNav()
                R.id.itemProfil -> showNav()
                else -> hideNav()
            }
        }
    }

    private fun showNav() {
        bottomNav.visibility = View.VISIBLE
        navView.visibility = View.VISIBLE
    }

    private fun hideNav() {
        bottomNav.visibility = View.GONE
        navView.visibility = View.GONE
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, drawerLayout) || super.onSupportNavigateUp()
    }
}