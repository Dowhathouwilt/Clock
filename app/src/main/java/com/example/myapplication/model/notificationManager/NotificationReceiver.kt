package com.example.myapplication.model.notificationManager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotificationReceiver:BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val service = AlarmNotificationManager(context)
        //TODO: set cancellation and rescheduling alarms Intents
    }
}