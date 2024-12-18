package com.example.locationreminders.data.mappers

import com.example.locationreminders.data.Reminder
import com.example.locationreminders.domain.model.Notes
import com.google.android.gms.maps.model.LatLng

fun Notes.toReminder(): Reminder {
    val latLng = location.toLatLng()
    return Reminder(
        id = this.id.toLong(),
        title = this.title,
        description = this.description,
        location = latLng
    )
}

fun String.toLatLng(): LatLng {
    return try {
        val (latitude, longitude) = this.split(",").map { it.trim().toDouble() }
        LatLng(latitude, longitude)
    } catch (e: Exception) {
        LatLng(0.0, 0.0)
    }
}

fun Reminder.toNote(): Notes {
    return Notes(
        id = this.id.toInt(),
        title = this.title,
        description = this.description,
        location = this.location.toLocationString()
    )
}

fun LatLng.toLocationString(): String {
    return "$latitude,$longitude"
}

fun List<Notes>.toReminderList(): List<Reminder> {
    return this.map { it.toReminder() }
}