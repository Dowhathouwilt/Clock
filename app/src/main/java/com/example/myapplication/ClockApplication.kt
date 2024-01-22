package com.example.myapplication

import android.app.Application
import com.example.myapplication.database.ClockRepository

class ClockApplication(): Application(){
    override fun onCreate() {
        super.onCreate()
        ClockRepository.initialize(this)
    }
}