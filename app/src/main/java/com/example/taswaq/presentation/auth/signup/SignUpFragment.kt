package com.example.taswaq.presentation.auth.signup

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.taswaq.R
import com.example.taswaq.databinding.FragmentSignUpBinding
import com.example.taswaq.presentation.core.BaseFragment

class SignUpFragment : BaseFragment<FragmentSignUpBinding>() {
    override val layoutId = R.layout.fragment_sign_up

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            signIn.setOnClickListener {
                findNavController().navigate(SignUpFragmentDirections.actionSignUpToSignIn())
            }
        }
    }

}