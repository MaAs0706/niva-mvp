package com.niva.safety

import android.app.Application
import com.google.firebase.FirebaseApp

class NivaApplication: Application(){

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}
