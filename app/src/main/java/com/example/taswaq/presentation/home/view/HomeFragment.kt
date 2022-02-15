package com.example.taswaq.presentation.home.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.taswaq.R
import com.example.taswaq.domain.constants.HomePageProductsListArgs.FEATURED
import com.example.taswaq.domain.constants.HomePageProductsListArgs.BEST_SELLER
import com.example.taswaq.databinding.FragmentHomeBinding
import com.example.taswaq.presentation.common.view.CategoriesAdapter
import com.example.taswaq.presentation.common.view.ProductsAdapter
import com.example.taswaq.domain.core.BaseFragment
import com.example.taswaq.presentation.home.HomeViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val TAG = "HomeFragment"
    override val layoutId = R.layout.fragment_home
    override val drawerIcon: Int = R.drawable.ic_menu
    private val homeViewModel: HomeViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        with(homeViewModel) {
            with(binding) {
                viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                    categories.map(::CategoriesAdapter).collect(categoriesList::setAdapter)
                }
                viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                    featured.map(::ProductsAdapter).collect(featuredList::setAdapter)
                }
                viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                    bestSellers.map(::ProductsAdapter).collect(bestSellerList::setAdapter)
                }
            }

        }
    }

    private fun initViews() {
        with(binding) {
            seeAllFeatured.setOnClickListener {
                findNavController()
                    .navigate(
                        HomeFragmentDirections.actionHomeToSeeProductsOfTitle(FEATURED)
                    )
            }
            seeAllBestSeller.setOnClickListener {
                findNavController()
                    .navigate(
                        HomeFragmentDirections.actionHomeToSeeProductsOfTitle(BEST_SELLER)
                    )
            }
            seeAllCategories.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.actionHomeToSeeAllCategories())
            }
        }
    }
}