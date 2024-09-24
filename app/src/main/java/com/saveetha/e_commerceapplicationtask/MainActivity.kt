package com.saveetha.e_commerceapplicationtask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.saveetha.e_commerceapplicationtask.Fragments.AllProductsFragment
import com.saveetha.e_commerceapplicationtask.Fragments.MyOrdersFragment
import com.saveetha.e_commerceapplicationtask.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        // Enable the up button (hamburger icon)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(true)

        binding.toolbar.setNavigationOnClickListener {
            binding.drawerLayout.openDrawer(GravityCompat.START)
        }

        val allProductsFragment = AllProductsFragment()
        replaceFragment(allProductsFragment)

        binding.sideNavigationView.setNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId) {
                R.id.orders -> {
                    val myOrdersFragment = MyOrdersFragment()
                    replaceFragment(myOrdersFragment)
                    binding.drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }
                else -> false
            }

        }

    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)
        val backStackCount = fragmentManager.backStackEntryCount
        if (backStackCount > 0) {
            val topBackStackEntry = fragmentManager.getBackStackEntryAt(backStackCount - 1)
            val topFragmentName = topBackStackEntry.name
            if (topFragmentName != fragment.javaClass.name) {
                fragmentTransaction.addToBackStack(null)
            }
        } else {
            if (fragmentManager.findFragmentById(R.id.frameLayout) != null) {
                fragmentTransaction.addToBackStack(null)
            }
        }
        fragmentTransaction.commit()
    }

}