package com.niva.safety.session

import android.content.Context
import android.content.Intent
import android.location.Location
import com.niva.safety.location.LocationForegroundService
import kotlinx.coroutines.*

object SessionManager {
    private var active = false
    private val scope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    fun startSession(ctx: Context) {
        if (active) return
        active = true
        val svc = Intent(ctx, LocationForegroundService::class.java)
        ctx.startForegroundService(svc)
        // store session start locally / Firestore later
    }

    fun stopSession(ctx: Context) {
        if (!active) return
        active = false
        val svc = Intent(ctx, LocationForegroundService::class.java)
        ctx.stopService(svc)
    }

    fun onLocationUpdate(ctx: Context, loc: Location) {
        // Save locally or send to Firestore
        // Evaluate simple heuristics: speed / timestamp
        // For MVP: print/log and optionally trigger check-in after inactivity
    }
}

