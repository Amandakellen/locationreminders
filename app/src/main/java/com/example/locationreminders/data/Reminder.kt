package com.example.locationreminders.data

import com.google.android.gms.maps.model.LatLng

data class Reminder(
    val id: Long = 0,
    val title: String,
    val description: String,
    val location: LatLng
)