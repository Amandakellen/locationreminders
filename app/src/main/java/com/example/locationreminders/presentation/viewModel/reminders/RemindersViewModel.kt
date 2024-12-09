package com.example.locationreminders.presentation.viewModel.reminders


import androidx.lifecycle.*
import com.example.locationreminders.data.repository.RemindersRepository
import com.example.locationreminders.domain.model.Reminder
import kotlinx.coroutines.launch

class RemindersViewModel(private val repository: RemindersRepository) : ViewModel() {

    // LiveData para a lista de lembretes
    private val _remindersList = MutableLiveData<List<Reminder>>()
    val remindersList: LiveData<List<Reminder>> = _remindersList

    // LiveData para mensagens de erro
    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> = _errorMessage

    // LiveData para controlar o estado "Sem Dados"
    private val _isEmpty = MutableLiveData<Boolean>(true)
    val isEmpty: LiveData<Boolean> = _isEmpty

    init {
        loadReminders()
    }

    fun loadReminders() {
        viewModelScope.launch {
            try {
                val reminders = repository.getReminders()
                _remindersList.value = reminders
                _isEmpty.value = reminders.isEmpty()
            } catch (e: Exception) {
                _errorMessage.value = "Erro ao carregar lembretes: ${e.message}"
            }
        }
    }


}

