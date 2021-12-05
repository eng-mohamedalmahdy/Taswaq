package com.example.taswaq.presentation.wishlist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.taswaq.R
import com.example.taswaq.databinding.FragmentWishlistBinding
import com.example.taswaq.presentation.common.view.ProductsAdapter
import com.example.taswaq.presentation.core.BaseFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import org.koin.androidx.viewmodel.ext.android.viewModel


class WishlistFragment : BaseFragment<FragmentWishlistBinding>() {
    override val layoutId = R.layout.fragment_wishlist
    override val drawerIcon = R.drawable.ic_menu
    private val viewModel: WishlistViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.getWishlist()
                .map(::ProductsAdapter)
                .collect(binding.productsList::setAdapter)
        }
    }

}