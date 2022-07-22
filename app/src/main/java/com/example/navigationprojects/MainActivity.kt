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

        b.bottomNavigationView.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.dados -> {
                    loadFragment(DadosFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.calc -> {
                    loadFragment(CalcFragment())
                    return@setOnNavigationItemReselectedListener
                }
                R.id.imc -> {
                    loadFragment(IMCFragment())
                    return@setOnNavigationItemReselectedListener
                }
            }
        }
    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainerView,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }



}



