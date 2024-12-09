package com.example.locationreminders.presentation.viewModel.addreminders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.locationreminders.data.repository.RemindersRepository
import com.example.locationreminders.domain.model.Reminder
import kotlinx.coroutines.launch

class AddReminderViewModel(private val repository: RemindersRepository) : ViewModel() {

    var title: String = ""
    var description: String = ""
    var latitude: Double = 0.0
    var longitude: Double = 0.0

    fun saveReminder() {
        viewModelScope.launch {
            val reminder = Reminder(
                title = title,
                description = description,
                location = "Local Selecionado", // Pode ser dinâmico
                latitude = latitude,
                longitude = longitude
            )
            repository.saveReminder(reminder)
        }
    }
}
