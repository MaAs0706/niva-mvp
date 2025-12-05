package com.niva.safety.location

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.google.android.gms.location.*
import com.niva.safety.notifications.NotificationHelper
import com.niva.safety.session.SessionManager

class LocationForegroundService : Service() {
    private lateinit var fusedClient: FusedLocationProviderClient
    private lateinit var locationRequest: LocationRequest
    private lateinit var locationCallback: LocationCallback

    override fun onCreate() {
        super.onCreate()
        NotificationHelper.createChannels(this)
        val notification = NotificationHelper.buildForegroundNotification(this, "Monitoring session")
        startForeground(NotificationHelper.FOREGROUND_ID, notification)

        fusedClient = LocationServices.getFusedLocationProviderClient(this)
        // balanced power for MVP
        locationRequest = LocationRequest.Builder(Priority.PRIORITY_BALANCED_POWER_ACCURACY, 5000L)
            .setMinUpdateIntervalMillis(5000L)
            .build()

        locationCallback = object : LocationCallback() {
            override fun onLocationResult(result: LocationResult) {
                val loc = result.lastLocation ?: return
                SessionManager.onLocationUpdate(this@LocationForegroundService, loc)
            }
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startLocationUpdates()
        return START_STICKY
    }

    private fun startLocationUpdates() {
        try {
            fusedClient.requestLocationUpdates(locationRequest, locationCallback, mainLooper)
        } catch (e: SecurityException) {
            // permission not granted
        }
    }

    private fun stopLocationUpdates() {
        fusedClient.removeLocationUpdates(locationCallback)
    }

    override fun onDestroy() {
        stopLocationUpdates()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null
}

