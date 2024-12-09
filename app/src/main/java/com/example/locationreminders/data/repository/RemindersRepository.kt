package com.example.locationreminders.data.repository

import com.example.locationreminders.domain.model.Reminder
import com.example.locationreminders.data.local.ReminderDao

class RemindersRepository(private val dao: ReminderDao) {

    suspend fun saveReminder(reminder: Reminder) {
        dao.insertReminder(reminder)
    }

    suspend fun getReminders(): List<Reminder> = dao.getAllReminders()

    suspend fun getReminderById(id: Long): Reminder? = dao.getReminderById(id)
}
