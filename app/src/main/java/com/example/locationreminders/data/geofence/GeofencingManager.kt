package com.example.locationreminders.data.geofence

import android.content.Context
import android.app.PendingIntent
import android.content.Intent
import android.util.Log
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat
import com.example.locationreminders.domain.geofence.GeofencingService
import com.google.android.gms.location.Geofence
import com.google.android.gms.location.GeofencingClient
import com.google.android.gms.location.GeofencingRequest
import com.google.android.gms.location.LocationServices

class GeofencingManager(private val context: Context) {

    private val geofencingClient: GeofencingClient =
        LocationServices.getGeofencingClient(context)

    fun addGeofence(latitude: Double, longitude: Double, radius: Float) {
        // Verificar permissão de localização
        if (ActivityCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            // Criação do Geofence
            val geofence = Geofence.Builder()
                .setRequestId("ReminderGeofence")
                .setCircularRegion(latitude, longitude, radius)
                .setExpirationDuration(Geofence.NEVER_EXPIRE)
                .setTransitionTypes(Geofence.GEOFENCE_TRANSITION_ENTER or Geofence.GEOFENCE_TRANSITION_EXIT)
                .build()

            // Solicitação do Geofencing
            val geofenceRequest = GeofencingRequest.Builder()
                .setInitialTrigger(GeofencingRequest.INITIAL_TRIGGER_ENTER)
                .addGeofence(geofence)
                .build()

            // PendingIntent para o serviço que será chamado quando o geofence for ativado
            val geofencePendingIntent: PendingIntent = PendingIntent.getService(
                context, 0, Intent(context, GeofencingService::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT
            )

            // Adicionar o geofence
            geofencingClient.addGeofences(geofenceRequest, geofencePendingIntent)
                .addOnSuccessListener {
                    Log.d("Geofencing", "Geofence adicionado com sucesso")
                }
                .addOnFailureListener {
                    Log.e("Geofencing", "Erro ao adicionar geofence", it)
                }
        } else {
            // A permissão não foi concedida, você deve pedir permissão ao usuário
            Log.e("Geofencing", "Permissão de localização não concedida.")
            // Aqui você pode lançar uma solicitação de permissão, dependendo do seu contexto
        }
    }
}
