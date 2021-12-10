package com.example.taswaq.presentation.auth.welcome

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.taswaq.R
import com.example.taswaq.databinding.FragmentWelcomeBinding
import com.example.taswaq.presentation.core.BaseFragment

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>() {
    override val layoutId = R.layout.fragment_welcome
    override val drawerIcon: Int = R.drawable.ic_back

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            logIn.setOnClickListener {
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeToSignIn())

            }
            signUp.setOnClickListener {
                findNavController().navigate(WelcomeFragmentDirections.actionWelcomeToSignUp())
            }
        }
    }

}