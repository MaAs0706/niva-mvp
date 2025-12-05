package com.niva.safety.notifications

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat

object NotificationHelper {
    const val CHANNEL_ID_FOREGROUND = "niva_foreground"
    const val CHANNEL_ID_ALERT = "niva_alerts"
    const val FOREGROUND_ID = 101

    fun createChannels(ctx: Context) {
        val nm = ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (nm.getNotificationChannel(CHANNEL_ID_FOREGROUND) == null) {
            val ch = NotificationChannel(CHANNEL_ID_FOREGROUND, "Niva Tracking", NotificationManager.IMPORTANCE_LOW)
            ch.description = "Foreground tracking"
            nm.createNotificationChannel(ch)
        }
        if (nm.getNotificationChannel(CHANNEL_ID_ALERT) == null) {
            val ch = NotificationChannel(CHANNEL_ID_ALERT, "Niva Alerts", NotificationManager.IMPORTANCE_HIGH)
            ch.description = "Alert channel"
            nm.createNotificationChannel(ch)
        }
    }

    fun buildForegroundNotification(ctx: Context, content: String): Notification {
        return NotificationCompat.Builder(ctx, CHANNEL_ID_FOREGROUND)
            .setContentTitle("Niva active")
            .setContentText(content)
            .setSmallIcon(android.R.drawable.ic_menu_mylocation)
            .setOngoing(true)
            .build()
    }
}


