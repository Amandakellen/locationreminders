package com.example.locationreminders.presentation.viewModel.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.locationreminders.data.repository.FirebaseAuthRepository
import com.google.firebase.auth.FirebaseUser

class LoginViewModel : ViewModel() {
    private val repository = FirebaseAuthRepository()
    val user: LiveData<FirebaseUser?> = repository.user

    fun login(email: String, password: String, onResult: (Boolean) -> Unit) {
        repository.login(email, password, onResult)
    }

    fun logout() {
        repository.logout()
    }

    fun register(email: String, password: String, onResult: (Boolean) -> Unit) {
        repository.register(email, password, onResult)
    }
}