package com.example.locationreminders.di

import com.example.locationreminders.data.repository.FirebaseAuthRepository
import com.example.locationreminders.presentation.viewModel.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    factory { FirebaseAuthRepository() }
    viewModel { LoginViewModel(get()) }
}