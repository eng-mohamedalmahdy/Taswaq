package com.example.taswaq.presentation.cart.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.taswaq.R
import com.example.taswaq.databinding.FragmentCartBinding
import com.example.taswaq.presentation.common.viewmodel.CartViewModel
import com.example.taswaq.presentation.core.BaseFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

private const val TAG = "CartFragment"

class CartFragment : BaseFragment<FragmentCartBinding>() {
    override val layoutId = R.layout.fragment_cart
    override val drawerIcon = R.drawable.ic_back
    val viewModel: CartViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            val cartAdapter = CartAdapter(
                onIncCLick = viewModel::addToCart,
                onDecCLick = viewModel::removeOneFromCart,
                onDeleteCLick = viewModel::removeAllFromCart
            )
            productsList.adapter = cartAdapter

            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                viewModel.getCartItems().collect(cartAdapter::submitList)
            }
            continueBtn.setOnClickListener {
                findNavController().navigate(
                    CartFragmentDirections.actionCartFragmentToAddressFragment(
                        true
                    )
                )
            }
        }
    }

}