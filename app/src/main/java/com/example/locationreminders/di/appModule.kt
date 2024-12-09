package com.example.locationreminders.di

import androidx.room.Room
import com.example.locationreminders.data.local.RemindersDatabase
import com.example.locationreminders.data.repository.RemindersRepository
import com.example.locationreminders.presentation.viewModel.reminders.RemindersViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single {
        Room.databaseBuilder(
            get(),
            RemindersDatabase::class.java,
            "reminders_db"
        ).fallbackToDestructiveMigration()
            .build()
    }

    single { get<RemindersDatabase>().reminderDao() }
    single{ RemindersRepository(get()) }
    viewModel { RemindersViewModel(get()) }

}