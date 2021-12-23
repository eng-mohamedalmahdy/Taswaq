package com.example.taswaq.presentation.payment.view

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.taswaq.R
import com.example.taswaq.databinding.FragmentPaymentBinding
import com.example.taswaq.databinding.PaymentDialogBinding
import com.example.taswaq.domain.model.DomainVisa
import com.example.taswaq.presentation.core.BaseFragment
import com.example.taswaq.presentation.payment.viewModel.PaymentViewModel
import es.dmoral.toasty.Toasty
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.withTimeout
import org.koin.androidx.viewmodel.ext.android.viewModel

class PaymentFragment : BaseFragment<FragmentPaymentBinding>() {

    override val layoutId: Int = R.layout.fragment_payment
    override val drawerIcon: Int = R.drawable.ic_back
    private val viewModel: PaymentViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding){
            addCardText.setOnClickListener {
                showAddCardDialog()
            }

            lifecycleOwner?.lifecycleScope?.launchWhenCreated {
                viewModel.getVisaCardList().collect {
                    paymentCardList.adapter = VisaCardAdapter(it)
                }
            }


          lifecycleOwner?.lifecycleScope?.launchWhenCreated {

            val subTotal=  viewModel.getSubTotalPrice().collect( )
              subtotal.text = subTotal.toString()
          }


        }


    }

    private fun showAddCardDialog() {
      val dialogBinding : PaymentDialogBinding? = PaymentDialogBinding.inflate(
          LayoutInflater.from(context),null,false,R.layout.payment_dialog
      )

    // val cardDialogView = LayoutInflater.from(context).inflate(R.layout.payment_dialog,null)
     val mBuilder = AlertDialog.Builder(context)
                               .setView(dialogBinding?.root)
     val mAlertDialog = mBuilder.show()

        dialogBinding?.addVisaBtn?.setOnClickListener {
            if(isValide(dialogBinding)) {
                val visaNumber = dialogBinding?.visaNoEt.text.toString()
                val visaDate = dialogBinding?.visaDateEt.text.toString()
                val visaUserName = dialogBinding?.visaUsernameEt.text.toString()
                val domainVisa = DomainVisa(visaNumber, visaDate, visaUserName)
                viewModel.addToVisaCrdList(domainVisa)
            }
        }

        dialogBinding?.cancelBtn?.setOnClickListener {
            mAlertDialog.dismiss()
        }

    }

    // validate dialog data
    private fun isValide(binding : PaymentDialogBinding?): Boolean {
        var valid = true

            val visaNumber = binding?.visaNoEt?.text.toString()
            if(visaNumber.isEmpty()){
                Toast.makeText(context," please enter the visa number ",Toast.LENGTH_LONG).show()
                valid = false
            }

            val visaDate = binding?.visaDateEt?.text.toString()
            if(visaDate.isEmpty()){
                Toast.makeText(context," please enter the visa out_date",Toast.LENGTH_LONG).show()
                valid = false
            }
        val visaUserName = binding?.visaDateEt?.text.toString()
        if(visaUserName.isEmpty()){
            Toast.makeText(context," please enter your name",Toast.LENGTH_LONG).show()
            valid = false
        }
            return valid

    }
}


