package com.example.myapplication

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import com.example.myapplication.app.api.ClockHttpRepository
import com.example.myapplication.app.database.ClockRepository

class ClockApplication() : Application() {
    override fun onCreate() {
        super.onCreate()
        ClockRepository.initialize(this)
        ClockHttpRepository.initialize()
        createNotificationChannel(
            R.string.channel_id,
            R.string.channel_name,
            R.string.channel_description,
            NotificationManager.IMPORTANCE_HIGH
        )
    }

    private fun createNotificationChannel(channelId:Int, channelName: Int, channelDescription: Int, channelImportance: Int) {
        val channel = NotificationChannel(
            getString(channelId),
            getString(channelName),
            channelImportance
        ).apply {
            description = getString(channelDescription)
        }
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(channel)
    }
}