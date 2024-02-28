package com.example.myapplication.model.alarmManager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import com.example.myapplication.R
import com.example.myapplication.model.Alarm
import com.example.myapplication.model.notificationManager.AlarmNotificationManager


class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val alarmScheduler = AndroidAlarmScheduler(context)
        val notification = AlarmNotificationManager(context)
        val alarm = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            intent.getParcelableExtra(
                EXTRA_ALARM,
                Alarm::class.java
            )
        else intent.getParcelableExtra(EXTRA_ALARM)
        if (alarm != null) {
            notification.showNotification(alarm)
            alarmScheduler.schedule(alarm)
        }
    }
}