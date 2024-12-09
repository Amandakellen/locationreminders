package com.example.locationreminders.domain.geofence

import android.annotation.SuppressLint
import android.app.IntentService
import android.app.PendingIntent
import android.content.Intent
import com.example.locationreminders.domain.model.Reminder
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingClient
import com.google.android.gms.location.GeofencingRequest
import com.google.android.gms.location.LocationServices

class GeofencingService : IntentService("GeofencingService") {

    private val geofencingClient: GeofencingClient by lazy { LocationServices.getGeofencingClient(applicationContext) }

    override fun onHandleIntent(intent: Intent?) {
        // Obtém os dados do lembrete a partir do Intent
        val reminderId = intent?.getLongExtra("reminderId", -1)
        // Aqui você implementa a lógica para verificar se o geofencing foi acionado
    }

    @SuppressLint("MissingPermission")
    private fun addGeofence(reminder: Reminder) {
        val geofence = Geofence.Builder()
            .setRequestId(reminder.id.toString())
//            .setCircularRegion(reminder.latitude, reminder.longitude, 100f) // Raio de 100 metros
            .setExpirationDuration(Geofence.NEVER_EXPIRE)
            .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER)
            .build()

        val geofencingRequest = GeofencingRequest.Builder()
            .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER)
            .addGeofence(geofence)
            .build()

        val geofencePendingIntent = PendingIntent.getService(
            this,
            0,
            Intent(this, GeofencingService::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        geofencingClient.addGeofences(geofencingRequest, geofencePendingIntent)
            .addOnSuccessListener {
                // Geofence adicionado com sucesso
            }
            .addOnFailureListener {
                // Falha ao adicionar o geofence
            }
    }
}
