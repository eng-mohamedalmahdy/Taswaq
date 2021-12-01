package com.example.taswaq.presentation.auth.signin

import androidx.lifecycle.ViewModel
import com.example.taswaq.application.LogInRepository

class LogInViewModel(private val repository: LogInRepository) : ViewModel() {

    fun signIn(email: String, password: String) = repository.signIn(email, password)
}