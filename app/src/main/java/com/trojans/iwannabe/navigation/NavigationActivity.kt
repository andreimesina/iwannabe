package com.trojans.iwannabe.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.trojans.iwannabe.R
import com.trojans.iwannabe.careerpath.CareerPathFragment
import com.trojans.iwannabe.home.HomeFragment
import com.trojans.iwannabe.messenger.UsersFragment

class NavigationActivity : FragmentActivity() {

    private lateinit var bottomNavigationBar: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)

        bottomNavigationBar = findViewById(R.id.bottom_navigation)

        navigateTo(HomeFragment(), "home")
        bottomNavigationBar.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bottom_navigation_item_home -> navigateTo(HomeFragment(), "home")
                R.id.bottom_navigation_item_careerpath -> navigateTo(CareerPathFragment(), "career")
                R.id.bottom_navigation_item_messenger -> navigateTo(UsersFragment(), "messenger")
            }

            true
        }
    }

    private fun navigateTo(fragment: Fragment, tag: String) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.container, fragment, tag)
            .addToBackStack(null)
            .commit()
    }
}
