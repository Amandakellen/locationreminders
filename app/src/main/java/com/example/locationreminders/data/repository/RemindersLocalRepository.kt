package com.example.locationreminders.data.repository

import com.example.locationreminders.data.Reminder
import com.example.locationreminders.data.local.NoteDao
import com.example.locationreminders.data.mappers.toNote
import com.example.locationreminders.data.mappers.toReminderList
import com.example.locationreminders.domain.model.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemindersLocalRepository(private val noteDao: NoteDao) {

    suspend fun insertNote(reminder: Reminder) {
        withContext(Dispatchers.IO) {
            noteDao.insert(reminder.toNote())
        }
    }

    suspend fun getAllNotes(): List<Reminder> {
        return withContext(Dispatchers.IO) {
            noteDao.getAllNotes().toReminderList()
        }
    }
}