package com.example.taswaq.presentation.address.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.taswaq.R
import com.example.taswaq.databinding.FragmentAddressBinding
import com.example.taswaq.presentation.address.viewmodel.AddressViewModel
import com.example.taswaq.presentation.common.view.CategoriesAdapter
import com.example.taswaq.presentation.core.BaseFragment
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddressFragment : BaseFragment<FragmentAddressBinding>() {
    override val layoutId: Int = R.layout.fragment_address
    override val drawerIcon: Int = R.drawable.ic_back
    private val viewModel: AddressViewModel by viewModel()
    private val args: AddressFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {


            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                viewModel.getAddressList.collect {
                    binding.addressRv.adapter = AddressAdapter(it)
                }
            }
            addAddressText.setOnClickListener {
                findNavController().navigate(
                    AddressFragmentDirections
                        .actionAddressFragmentToCreateAddressFragment()
                )
            }
            continueToPayBtn.setOnClickListener {
            findNavController()
                .navigate(AddressFragmentDirections
                    .actionAddressFragmentToPaymentFragment())
            }
        }

    }

    override fun onResume() {
        super.onResume()
        binding.continueToPayBtn.visibility = if (args.isCheckingOut) View.VISIBLE else View.GONE

    }
}

