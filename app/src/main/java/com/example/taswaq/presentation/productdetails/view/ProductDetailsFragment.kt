package com.example.taswaq.presentation.productdetails.view

import android.os.Bundle
import android.view.View
import androidx.databinding.adapters.TextViewBindingAdapter.setText
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.taswaq.R
import com.example.taswaq.databinding.FragmentProductDetailsBinding
import com.example.taswaq.presentation.core.BaseFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProductDetailsFragment : BaseFragment<FragmentProductDetailsBinding>() {

    private val viewModel: ProductDetailsViewModel by viewModel()
    override val layoutId = R.layout.fragment_product_details

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                viewModel.images.map { it.map(::SlideModel) }.collect {
                    productImages.setImageList(it, ScaleTypes.CENTER_CROP)
                }
            }
            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                viewModel.title.collect(productName::setText)
            }

            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                viewModel.priceAfter.map(Double::toString).collect(priceAfterDiscount::setText)
            }
            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                viewModel.priceAfter.map(Double::toString).collect(priceAfterDiscount::setText)
            }
            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                viewModel.reviewsCount.map(Int::toString).collect(reviewsCount::setText)
            }
            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                viewModel.description.collect(description::setText)
            }

            addToCart.setOnClickListener {
                findNavController().navigate(ProductDetailsFragmentDirections.actionProductDetailsFragmentToWelcomeFragment())
            }
        }
    }

}