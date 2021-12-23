package com.example.taswaq.presentation.payment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.taswaq.R
import com.example.taswaq.application.PaymentRepository
import com.example.taswaq.databinding.PaymentDialogFragmentBinding
import com.example.taswaq.presentation.payment.viewModel.PaymentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PaymentDialogFragment : DialogFragment(){
    lateinit var dialogBinding : PaymentDialogFragmentBinding
    lateinit var viewModel: PaymentViewModel
    lateinit var paymentRepository: PaymentRepository
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        dialogBinding  = PaymentDialogFragmentBinding
            .inflate(LayoutInflater.from(context),container,false)
        paymentRepository = PaymentRepository()
        viewModel = PaymentViewModel(paymentRepository)
        return dialogBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         with(dialogBinding){
             cancelBtn.setOnClickListener {
                 findNavController().navigateUp() }
             addVisaBtn.setOnClickListener {
                 if(isValid()){
                     val visaNumber = visaNoEt.text.toString()
                     val visaUserName = visaUsernameEt.text.toString()
                     val visaDay = dayEt.text.toString()
                     val visaMonth = monthEt.text.toString()
                     val visaYear = yearEt.text.toString()
                   viewModel.addToVisaCrdList(visaNumber,visaUserName,visaDay,visaMonth,visaYear)

                     findNavController().navigateUp()
                     clearViews()
                 }
             }

         }

    }

    fun clearViews(){
        with(dialogBinding){
            yearEt.setText("")
            monthEt.setText("")
            dayEt.setText("")
            visaUsernameEt.setText("")
            visaNoEt.setText("")
        }
    }

    private fun isValid(): Boolean {
        var valid = true
         with(dialogBinding) {
             val visaNumber = visaNoEt.text.toString()
             if (visaNumber.isEmpty()) {
                 Toast.makeText(context, " please enter the visa number ", Toast.LENGTH_LONG).show()
                 valid = false
             }

             val day = dayEt.text.toString()
             if (day.isEmpty()) {
                 Toast.makeText(context, " please enter correct date!", Toast.LENGTH_LONG)
                     .show()
                 valid = false
             }
             val month = monthEt.text.toString()
             if (month.isEmpty()) {
                 Toast.makeText(context, " please enter correct date!", Toast.LENGTH_LONG)
                     .show()
                 valid = false
             }
             val year = yearEt.text.toString()
             if (year.isEmpty()) {
                 Toast.makeText(context, " please enter correct date!", Toast.LENGTH_LONG)
                     .show()
                 valid = false
             }

             val visaUserName = visaUsernameEt.text.toString()
             if (visaUserName.isEmpty()) {
                 Toast.makeText(context, " please enter your name", Toast.LENGTH_LONG).show()
                 valid = false
             }
             return valid
         }
    }
}