package com.example.locationreminders.presentation.viewModel.addreminders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.locationreminders.data.repository.RemindersLocalRepository
import com.example.locationreminders.domain.model.Reminder
import kotlinx.coroutines.launch

class AddReminderViewModel(private val repository: RemindersLocalRepository) : ViewModel() {

    var title: String = ""
    var description: String = ""
    var latitude: Double = 0.0
    var longitude: Double = 0.0

    fun saveReminder() {

    }
}
