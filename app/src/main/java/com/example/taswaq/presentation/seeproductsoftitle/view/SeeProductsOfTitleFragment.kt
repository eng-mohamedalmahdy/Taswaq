package com.example.taswaq.presentation.seeproductsoftitle.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.taswaq.R
import com.example.taswaq.databinding.FragmentSeeProductsOfTitleBinding
import com.example.taswaq.presentation.common.view.ProductsAdapter
import com.example.taswaq.presentation.core.BaseFragment
import com.example.taswaq.presentation.seeproductsoftitle.SeeProductsOfTitleViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import org.koin.androidx.viewmodel.ext.android.viewModel


class SeeProductsOfTitleFragment : BaseFragment<FragmentSeeProductsOfTitleBinding>() {


    override val layoutId = R.layout.fragment_see_products_of_title
    override val drawerIcon: Int = R.drawable.ic_back

    private lateinit var args: SeeProductsOfTitleFragmentArgs
    private val viewModel: SeeProductsOfTitleViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        args = SeeProductsOfTitleFragmentArgs.fromBundle(requireArguments())
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            title.text = viewModel.getProperTitle(args.productsType)
        }
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel
                .getProperProductsList(args.productsType)
                .map(::ProductsAdapter)
                .collect(binding.productsList::setAdapter)
        }
    }


}