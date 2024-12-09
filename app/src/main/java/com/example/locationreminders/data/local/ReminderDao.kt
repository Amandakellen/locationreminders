package com.example.locationreminders.data.local

import androidx.room.*
import com.example.locationreminders.domain.model.Reminder


@Dao
interface ReminderDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReminder(reminder: Reminder)

    @Query("SELECT * FROM reminders")
    suspend fun getAllReminders(): List<Reminder>

    @Query("SELECT * FROM reminders WHERE id = :id")
    suspend fun getReminderById(id: Long): Reminder?

    @Delete
    suspend fun deleteReminder(reminder: Reminder)
}