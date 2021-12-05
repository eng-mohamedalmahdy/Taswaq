package com.example.taswaq.presentation.profile.view

import com.example.taswaq.R
import com.example.taswaq.databinding.FragmentProductDetailsBinding
import com.example.taswaq.presentation.core.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment<FragmentProductDetailsBinding>() {

    override val layoutId = R.layout.fragment_profile
    override val drawerIcon: Int = R.drawable.ic_back
    private val viewModel : ProfileViewModel by viewModel()
}