package com.example.taswaq.presentation.productdetails.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.taswaq.R
import com.example.taswaq.databinding.FragmentProductDetailsBinding
import com.example.taswaq.domain.isUserAuthenticated
import com.example.taswaq.presentation.common.viewmodel.CartViewModel
import com.example.taswaq.presentation.core.BaseFragment
import es.dmoral.toasty.Toasty
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

private const val TAG = "ProductDetailsFragment"

class ProductDetailsFragment : BaseFragment<FragmentProductDetailsBinding>() {

    private val cartViewModel: CartViewModel by sharedViewModel()
    override val layoutId = R.layout.fragment_product_details
    override val drawerIcon: Int = R.drawable.ic_back
    private val productDetailsFragmentArgs: ProductDetailsFragmentArgs by navArgs()
    private val productDetailsViewModel: ProductDetailsViewModel by viewModel {
        parametersOf(
            productDetailsFragmentArgs.productId
        )
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                productDetailsViewModel.images.map { it.map(::SlideModel) }.collect {
                    productImages.setImageList(it, ScaleTypes.CENTER_CROP)
                }
            }
            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                productDetailsViewModel.title.collect(productName::setText)
            }

            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                productDetailsViewModel.priceAfter.map { "\$${it}" }
                    .collect(priceAfterDiscount::setText)
            }
            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                productDetailsViewModel.priceBefore.map { "\$${it}" }
                    .collect(priceBeforeDiscount::setText)
            }
            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                productDetailsViewModel.reviewsCount.map(Int::toString)
                    .collect(reviewsCount::setText)
            }
            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                productDetailsViewModel.description.collect(description::setText)
            }

            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                productDetailsViewModel.rate.map(Double::toString).collect(productRate::setText)
            }

            addToCart.setOnClickListener {
                viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                    requireContext().isUserAuthenticated.collectLatest { authed: Boolean ->
                        if (!authed)
                            findNavController().navigate(ProductDetailsFragmentDirections.actionProductDetailsFragmentToWelcomeFragment())
                        else {
                            productDetailsViewModel.id.collect(cartViewModel::addToCart)
                            Toasty.success(requireContext(), R.string.added_to_cart).show()
                        }
                    }

                }
            }
        }
    }

}