package com.example.navigationprojects

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.navigationprojects.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var b:ActivityMainBinding
    private lateinit var navController: NavController
    lateinit var toolbar: ActionBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        toolbar = supportActionBar!!
        val navView:BottomNavigationView=findViewById(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragmentContainerView)
        val appConfiguration = AppBarConfiguration(setOf(R.id.dados,R.id.calc,R.id.imc))
        setupActionBarWithNavController(navController,appConfiguration)
        navView.setupWithNavController(navController)
        setBottomNavVisibility()

    }
    private fun setBottomNavVisibility(){
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when(destination.id){
                R.id.navigation_frag_b -> hideBottomNav()
                else -> showBottomNav()
            }
        }
    }

    private fun showBottomNav(){
        b.bottomNavigationView.visibility = View.VISIBLE
    }

    private fun hideBottomNav(){
        b.bottomNavigationView.visibility = View.GONE
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.fragmentContainerView).navigateUp()
    }


}



