package com.example.locationreminders.domain.geofence

import android.content.Intent
import android.app.Notification
import android.os.IBinder
import android.app.Service
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.locationreminders.R
import androidx.core.app.JobIntentService

class GeofenceService : JobIntentService() {

    // JOB_ID único
    companion object {
        const val JOB_ID = 1000
    }

    // Este método substitui o onHandleIntent
    override fun onHandleWork(intent: Intent) {
        // Lógica para processar o trabalho em segundo plano
        val title = "Lembrete de POI"
        showNotification(title)
    }

    // Função para exibir a notificação
    private fun showNotification(title: String) {
        val notification = NotificationCompat.Builder(this, "GeofenceChannel")
            .setContentTitle("Você entrou em uma área de lembrete!")
            .setContentText(title)
            .setSmallIcon(R.drawable.ic_notification)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        val notificationManager = NotificationManagerCompat.from(this)
        notificationManager.notify(1, notification)
    }

    // Usado para enfileirar o trabalho
    fun enqueueWork(context: Context, intent: Intent) {
        enqueueWork(context, GeofenceService::class.java, JOB_ID, intent)
    }
}
