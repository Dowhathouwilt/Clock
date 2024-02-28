package com.example.myapplication.model.notificationManager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val cancel = intent.getBooleanExtra(EXTRA_CANCEL, false)
        if (cancel) {
            val alarmIdCode = intent.getIntExtra(EXTRA_ALARM_ID, -1)
            AlarmNotificationManager(context).cancelNotification(alarmIdCode)
        }
    }
}