package com.example.locationreminders.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.locationreminders.domain.model.Reminder

@Database(entities = [Reminder::class], version = 1, exportSchema = false)
abstract class RemindersDatabase : RoomDatabase() {
    abstract fun reminderDao(): ReminderDao
}