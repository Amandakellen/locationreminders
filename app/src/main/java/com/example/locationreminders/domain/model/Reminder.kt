package com.example.locationreminders.domain.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "reminders")
data class Reminder(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    @ColumnInfo(name = "reminder_title")
    val title: String,

    @ColumnInfo(name = "reminder_description")
    val description: String,

    @ColumnInfo(name = "reminder_location")
    val location: String,

    val latitude: Double,
    val longitude: Double
)
