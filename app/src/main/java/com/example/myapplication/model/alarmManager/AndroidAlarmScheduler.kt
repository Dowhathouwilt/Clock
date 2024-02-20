package com.example.myapplication.model.alarmManager

import android.app.AlarmManager
import android.app.AlarmManager.AlarmClockInfo
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.example.myapplication.model.Alarm
import com.example.myapplication.model.AlarmTimeWorker

const val EXTRA_MESSAGE = "ALARM_MESSAGE"

class AndroidAlarmScheduler(
    private val context: Context
) : AlarmScheduler {

    private val alarmManager = context.getSystemService(AlarmManager::class.java)


    override fun schedule(alarm: Alarm) {
        val alarmTimeWorker = AlarmTimeWorker(alarm)
        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra(EXTRA_MESSAGE, "Alarm ${alarm.label} is triggered")
        }
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            alarm.id.hashCode(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }

    override fun cancel(alarm: Alarm) {
        alarmManager.cancel(
            PendingIntent.getBroadcast(
                context,
                alarm.id.hashCode(),
                Intent(context, AlarmReceiver::class.java),
                PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
        )
    }

}