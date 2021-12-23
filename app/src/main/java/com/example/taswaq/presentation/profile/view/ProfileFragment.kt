package com.example.taswaq.presentation.profile.view

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.taswaq.R
import com.example.taswaq.application.contentAsString
import com.example.taswaq.databinding.FragmentProfileBinding
import com.example.taswaq.presentation.core.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    override val layoutId = R.layout.fragment_profile
    override val drawerIcon: Int = R.drawable.ic_menu
    private val viewModel: ProfileViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.viewModel = viewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            addresses.setOnClickListener {
                ProfileFragmentDirections.actionProfileFragmentToAddressFragment(false)
            }
            updateProfile.setOnClickListener {
                viewModel?.phoneNumber?.value = phoneNumber.fullNumberWithPlus
                if (viewModel!!.profileDataChanged()) {
                    viewModel!!.updateProfile(password.contentAsString())
                } else {
                    findNavController().navigateUp()
                }
            }
            cards.setOnClickListener {

            }
        }
    }
}