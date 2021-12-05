package com.example.taswaq.presentation.core

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.taswaq.R
import androidx.navigation.ui.NavigationUI
import androidx.navigation.NavController
import com.google.android.material.navigation.NavigationView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.Navigation
import com.example.taswaq.databinding.ActivityMainBinding
import androidx.navigation.ui.AppBarConfiguration
import androidx.appcompat.app.ActionBarDrawerToggle


class MainActivity : AppCompatActivity() {
    private lateinit var mAppBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBarMain.toolbar)
        supportActionBar?.hide()

        val drawer: DrawerLayout = binding.drawerLayout
        val navigationView: NavigationView = binding.navView
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        mAppBarConfiguration = AppBarConfiguration.Builder(
            R.id.homeFragment,
            R.id.wishlistFragment
        )
            .setOpenableLayout(drawer)
            .build()

        val navController: NavController =
            Navigation.findNavController(this, R.id.nav_host_fragment_content_main)
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration)
        NavigationUI.setupWithNavController(navigationView, navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main)
        return (NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp())
    }
}
