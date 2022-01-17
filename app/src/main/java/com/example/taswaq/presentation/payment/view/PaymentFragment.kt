package com.example.taswaq.presentation.payment.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.taswaq.R
import com.example.taswaq.databinding.FragmentPaymentBinding
import com.example.taswaq.domain.core.BaseFragment
import com.example.taswaq.presentation.payment.viewModel.PaymentViewModel
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class PaymentFragment : BaseFragment<FragmentPaymentBinding>() {

    override val layoutId: Int = R.layout.fragment_payment
    override val drawerIcon: Int = R.drawable.ic_back
    private val viewModel: PaymentViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            addCardText.setOnClickListener {
              findNavController().navigate(PaymentFragmentDirections
                             .actionPaymentFragmentToPaymentDialogFragment())
            }

            viewLifecycleOwner.lifecycleScope.launchWhenCreated {
                viewModel.getVisaCardList().collect {
                    paymentCardList.adapter = VisaCardAdapter(it)

                }
            }


            viewLifecycleOwner.lifecycleScope.launchWhenCreated {

            val subTotal=  viewModel.getSubTotalPrice().collect( )
              subtotal.text = subTotal.toString()

          }


        }


    }




}


