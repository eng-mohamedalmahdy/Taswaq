package com.example.taswaq.presentation.auth.signin

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.taswaq.R
import com.example.taswaq.databinding.FragmentLogInBinding
import com.example.taswaq.domain.core.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LogInFragment : BaseFragment<FragmentLogInBinding>() {
    override val layoutId = R.layout.fragment_log_in
    override val drawerIcon: Int = R.drawable.ic_back
    val viewModel: LogInViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            logIn.setOnClickListener {
                val email = email.text.toString()
                val password = password.text.toString()
                viewModel.signIn(email, password)
            }
            signUp.setOnClickListener {
                findNavController().navigate(LogInFragmentDirections.actionLogInToSignUp())
            }
        }
    }
}