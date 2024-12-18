package com.example.locationreminders.di

import android.content.Context
import androidx.room.Room
import com.example.locationreminders.data.local.NoteDatabase
import com.example.locationreminders.data.repository.FirebaseAuthRepository
import com.example.locationreminders.data.repository.RemindersLocalRepository
import com.example.locationreminders.presentation.viewModel.login.LoginViewModel
import com.example.locationreminders.presentation.viewModel.reminders.RemindersViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single {
        Room.databaseBuilder(
            get<Context>(),
            NoteDatabase::class.java,
            "note_database"
        ).fallbackToDestructiveMigration().build()
    }

    single { get<NoteDatabase>().noteDao }

    single { FirebaseAuthRepository() }
    single { RemindersLocalRepository(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { RemindersViewModel(get()) }
}