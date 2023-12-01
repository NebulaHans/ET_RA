package com.example.myapplication

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication.fragments.DriverFragment
import com.example.myapplication.fragments.EngineerFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setBackgroundDrawable(ColorDrawable(Color.parseColor("#cccccc")))
        val driverFragment= DriverFragment()
        val engineerFragment= EngineerFragment()

        makeCurrentFragment(driverFragment)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_driver -> {
                    makeCurrentFragment(driverFragment)
                }
                R.id.menu_engineer -> {
                    makeCurrentFragment(engineerFragment)
                }
            }
            true
        }
    }
    private fun makeCurrentFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper,fragment)
            commit()
        }
    }
}