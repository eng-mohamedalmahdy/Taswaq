package com.example.taswaq.presentation.address.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.taswaq.R
import com.example.taswaq.application.contentAsString
import com.example.taswaq.databinding.FragmentCreateAddressBinding
import com.example.taswaq.domain.model.DomainAddress
import com.example.taswaq.presentation.address.viewmodel.CreateAddressViewModel
import com.example.taswaq.presentation.common.view.CategoriesAdapter
import com.example.taswaq.presentation.core.BaseFragment
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel


class CreateAddressFragment : BaseFragment<FragmentCreateAddressBinding>() {

    override val layoutId: Int = R.layout.fragment_create_address
    override val drawerIcon: Int? = R.drawable.ic_back
    private val viewModel: CreateAddressViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding){

              addAddressBtn.setOnClickListener {
                  if(isValide()) {
                      viewModel.addAddress(
                          cityEt.contentAsString(),
                          streetEt.contentAsString(),
                          latEt.contentAsString().toDouble(),
                          langEt.contentAsString().toDouble(),
                          notesEt.contentAsString()
                      )

                      // what action will be done here
                      findNavController().navigate(
                          CreateAddressFragmentDirections
                              .actionCreateAddressFragmentToAddressFragment()
                      )
                  }
              }
        }



    }
    private fun isValide(): Boolean {
        var valid = true
        with(binding){
            val street = streetLayout.editText?.text.toString()
            if(street.isEmpty()){
                streetLayout.error = " please enter the street name"
                valid = false
            }else{
                streetLayout.isErrorEnabled = false
            }

            val city = cityLayout.editText?.text.toString()
            if(city.isEmpty()){
                cityLayout.error = " please enter the city name"
                valid = false
            }else{
                cityLayout.isErrorEnabled = false
            }
            val lat = latLayout.editText?.text.toString()
            if(lat.isEmpty()){
                latLayout.error = " please enter the latitude"
                valid = false
            }else{
                latLayout.isErrorEnabled = false
            }
            val lang = langLayout.editText?.text.toString()
            if(lang.isEmpty()){
                langLayout.error = " please enter the langitude"
                valid = false
            }else{
                langLayout.isErrorEnabled = false
            }
            val notes = notesLayout.editText?.text.toString()
            if(notes.isEmpty()){
                notesLayout.error = " please enter your notes"
                valid = false
            }else{
                notesLayout.isErrorEnabled = false
            }
            return valid
        }
    }




}