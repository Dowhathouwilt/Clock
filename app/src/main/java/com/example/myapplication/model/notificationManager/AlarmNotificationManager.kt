package com.example.myapplication.model.notificationManager

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.icu.text.CaseMap.Title

import androidx.core.app.NotificationCompat
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.model.Alarm
import com.example.myapplication.model.alarmManager.AlarmReceiver

class AlarmNotificationManager(
    private val context: Context
) {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification(alarm: Alarm, channelId: String) {
        val activityIntent = Intent(context, MainActivity::class.java)
        val broadcastNotificationIntent = Intent(context, NotificationReceiver::class.java)
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val cancelIntent = PendingIntent.getBroadcast(
            context,
            2,
            broadcastNotificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val notification = NotificationCompat.Builder(context, channelId)
            .setContentText("${alarm.label} is running")
            .setContentTitle("Alarm")
            .setContentIntent(activityPendingIntent)
            .addAction(
                R.drawable.baseline_cancel_24,
                "Cancel",
                cancelIntent
            )
            .build()

        notificationManager.notify(
            alarm.id.hashCode(),
            notification
        )
    }

    fun cancelNotification(alarm: Alarm) {
        notificationManager.cancel(alarm.id.hashCode())
    }
}