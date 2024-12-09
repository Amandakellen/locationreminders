package com.example.locationreminders.data.repository

import com.example.locationreminders.data.local.ReminderDao
import com.example.locationreminders.domain.model.Reminder

class RemindersLocalRepository() {
   suspend fun getAllReminders(){}//: List<Reminder> = reminderDao.getAllReminders()
//
//    suspend fun insertReminder(reminder: Reminder) = reminderDao.insertReminder(reminder)
//
//    suspend fun deleteReminder(reminderId: Long) = reminderDao.deleteReminder(reminderId)
}
