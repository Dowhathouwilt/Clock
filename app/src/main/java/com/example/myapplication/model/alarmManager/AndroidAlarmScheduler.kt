package com.example.myapplication.model.alarmManager

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.example.myapplication.model.Alarm
import com.example.myapplication.model.utils.AlarmTimeWorker

const val EXTRA_ALARM = "ALARM_ID"

class AndroidAlarmScheduler(
    private val context: Context
) : AlarmSchedulerInterface {

    private val alarmManager = context.getSystemService(AlarmManager::class.java)

    override fun schedule(alarm: Alarm) {
        val alarmTimeWorker = AlarmTimeWorker(alarm)
        val intent = Intent(context, AlarmReceiver::class.java).apply {
            putExtra(EXTRA_ALARM, alarm)
        }
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            alarm.id.hashCode(),
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
        //TODO: add a new pendingIntent to open an app in notifications
        val clockInfo = AlarmManager.AlarmClockInfo(alarmTimeWorker.calendar.timeInMillis, pendingIntent)

        alarmManager.setAlarmClock(clockInfo, pendingIntent)
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