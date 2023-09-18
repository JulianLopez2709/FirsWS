package com.example.wordskill02application

import android.app.Application

class AppWs:Application() {
    companion object{
        lateinit var prefs :Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}