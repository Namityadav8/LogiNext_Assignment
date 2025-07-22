package com.example.loginext

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    private lateinit var homeFragment: HomeFragment
    private lateinit var orderFragment: OrderFragment
    private lateinit var thirdFragment: ThirdFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        homeFragment = HomeFragment()
        orderFragment = OrderFragment()
        thirdFragment = ThirdFragment()

        supportFragmentManager.beginTransaction()
            .add(R.id.container, thirdFragment, "3").hide(thirdFragment)
            .add(R.id.container, orderFragment, "2").hide(orderFragment)
            .add(R.id.container, homeFragment, "1")
            .commit()

        val nav = findViewById<BottomNavigationView>(R.id.bottomNav)
        nav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> { showFragment(homeFragment); true }
                R.id.nav_order -> { showFragment(orderFragment); true }
                R.id.nav_more -> { showFragment(thirdFragment); true }
                else -> false
            }
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.fragments.forEach {
            supportFragmentManager.beginTransaction().hide(it).commit()
        }
        supportFragmentManager.beginTransaction().show(fragment).commit()
    }
}