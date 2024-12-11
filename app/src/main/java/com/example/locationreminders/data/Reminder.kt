package com.example.locationreminders.data

data class Reminder(
    val id: Long = 0,
    val title: String,
    val description: String,
    val location: String
)