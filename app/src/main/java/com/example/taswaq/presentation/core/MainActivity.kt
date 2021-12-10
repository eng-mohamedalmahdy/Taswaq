package com.example.taswaq.presentation.core

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.taswaq.MainGraphDirections
import com.example.taswaq.R
import com.example.taswaq.databinding.ActivityMainBinding
import com.example.taswaq.presentation.common.viewmodel.CartViewModel
import com.google.android.material.navigation.NavigationView
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.nikartm.support.ImageBadgeView

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    private lateinit var mAppBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private val cartViewModel: CartViewModel by viewModel()

    @SuppressLint("UnsafeOptInUsageError")
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
            R.id.wishlistFragment,
            R.id.ordersFragment
        )
            .setOpenableLayout(drawer)
            .build()

        val navController: NavController =
            Navigation.findNavController(this, R.id.nav_host_fragment_content_main)
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration)
        NavigationUI.setupWithNavController(navigationView, navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.app_bar_menu, menu)


        val menuItem = menu?.findItem(R.id.menu_item_cart) as MenuItem
        val actionView = menuItem.actionView
        val badgeView: ImageBadgeView = actionView.findViewById(R.id.cart_menu_icon)
        actionView.setOnClickListener {
            findNavController(R.id.nav_host_fragment_content_main)
                .navigate(MainGraphDirections.actionToCart())
        }
        lifecycleScope.launch {
            cartViewModel.getCartItemsCount().collectLatest {
                badgeView.badgeValue = it
                Log.d(TAG, "onCreateOptionsMenu: $it")
            }
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main)
        return (NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp())
    }
}

