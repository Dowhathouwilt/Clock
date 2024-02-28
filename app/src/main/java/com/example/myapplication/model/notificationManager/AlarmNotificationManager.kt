package com.example.myapplication.model.notificationManager

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

import androidx.core.app.NotificationCompat
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.model.Alarm


const val EXTRA_CANCEL = "Cancel"
const val EXTRA_ALARM_ID = "Alarm_ID"

class AlarmNotificationManager(
    private val context: Context
) : AlarmNotificationInterface {
    private val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    override fun showNotification(alarm: Alarm) {
        val activityIntent = Intent(context, MainActivity::class.java)
        val cancelIntent = Intent(context, NotificationReceiver::class.java).apply {
            putExtra(EXTRA_CANCEL, true)
            putExtra(EXTRA_ALARM_ID, alarm.id.hashCode())
        }
        val activityPendingIntent = PendingIntent.getActivity(
            context,
            1,
            activityIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val actionCancelIntent = PendingIntent.getBroadcast(
            context,
            2,
            cancelIntent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        val notification = NotificationCompat.Builder(context, context.getString(R.string.channel_id))
            .setContentText("${alarm.label} is running")
            .setContentTitle("Alarm")
            .setContentIntent(activityPendingIntent)
            .setSmallIcon(R.drawable.baseline_alarm_on_24)
            .addAction(
                R.drawable.baseline_cancel_schedule_send_24,
                "Schedule",
                activityPendingIntent
            )
            .addAction(
                R.drawable.baseline_cancel_24,
                "Close",
                actionCancelIntent
            )
            .build()

        notificationManager.notify(
            alarm.id.hashCode(),
            notification
        )
    }

    override fun cancelNotification(alarmIdCode: Int) {
        notificationManager.cancel(alarmIdCode)
    }
}