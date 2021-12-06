package com.example.taswaq.presentation.myorders.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.taswaq.R
import com.example.taswaq.databinding.FragmentMyOrdersBinding
import com.example.taswaq.presentation.core.BaseFragment
import com.example.taswaq.presentation.myorders.MyOrdersViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyOrdersFragment : BaseFragment<FragmentMyOrdersBinding>() {
    override val layoutId = R.layout.fragment_my_orders
    override val drawerIcon = R.drawable.ic_menu
    val viewModel: MyOrdersViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.getOrdersHistory()
                .map(::OrdersListAdapter)
                .collect(binding.ordersList::setAdapter)
        }

    }
}