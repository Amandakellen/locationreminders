package com.example.locationreminders.presentation.viewModel.reminders

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.locationreminders.data.Reminder
import com.example.locationreminders.data.repository.RemindersLocalRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class RemindersViewModel(private val repository: RemindersLocalRepository) : ViewModel() {

    private val _reminder = MutableLiveData<List<Reminder?>?>()
    private val reminder: LiveData<List<Reminder?>?> = _reminder

    init {
        Log.d("RemindersViewModel", "ViewModel initialized")
    }

    fun insertNote(reminder: Reminder) {
        viewModelScope.launch {
            repository.insertNote(reminder)
        }

    }

    fun getAllNotes() {
        viewModelScope.launch {
            _reminder.value = repository.getAllNotes()
        }
    }
}