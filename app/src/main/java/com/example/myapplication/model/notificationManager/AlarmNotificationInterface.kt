package com.example.myapplication.model.notificationManager

import com.example.myapplication.model.Alarm

interface AlarmNotificationInterface {
    fun showNotification(alarm: Alarm)
    fun cancelNotification(alarmIdCode:Int)
}