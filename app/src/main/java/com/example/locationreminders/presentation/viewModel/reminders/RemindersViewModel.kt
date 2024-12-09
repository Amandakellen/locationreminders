package com.example.locationreminders.presentation.viewModel.reminders


import android.app.Application
import androidx.lifecycle.*
import com.example.locationreminders.data.local.ReminderDatabase
import com.example.locationreminders.data.repository.RemindersLocalRepository
import com.example.locationreminders.domain.model.Reminder
import kotlinx.coroutines.launch

class RemindersViewModel(application: Application) : AndroidViewModel(application) {

    private val remindersRepository: RemindersLocalRepository

    private val _reminders = MutableLiveData<List<Reminder>>()
    val reminders: LiveData<List<Reminder>> get() = _reminders

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> get() = _error

    init {
        val database = ReminderDatabase.getDatabase(application)
        remindersRepository = RemindersLocalRepository(database.reminderDao())
    }

    fun loadReminders() {
        viewModelScope.launch {
            try {
                val reminderList = remindersRepository.getAllReminders()
                _reminders.value = reminderList
                _error.value = null
            } catch (e: Exception) {
                _error.value = "Erro ao carregar os lembretes"
            }
        }
    }
}



