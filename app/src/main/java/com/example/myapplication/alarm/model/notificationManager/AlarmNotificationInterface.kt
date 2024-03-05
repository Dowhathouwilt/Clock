package com.example.myapplication.alarm.model.notificationManager

import com.example.myapplication.alarm.model.Alarm

interface AlarmNotificationInterface {
    fun showNotification(alarm: Alarm)
    fun cancelNotification(alarmIdCode: Int)
}