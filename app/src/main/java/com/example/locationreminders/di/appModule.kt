package com.example.locationreminders.di

import androidx.room.Room
import com.example.locationreminders.data.local.ReminderDatabase
import com.example.locationreminders.data.repository.RemindersLocalRepository
import com.example.locationreminders.presentation.viewModel.reminders.RemindersViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            ReminderDatabase::class.java,
            "reminder_database"
        ).fallbackToDestructiveMigration().build()
    }

    single { get<ReminderDatabase>().reminderDao() }

    single { RemindersLocalRepository() }
    viewModel { RemindersViewModel(get()) }
}