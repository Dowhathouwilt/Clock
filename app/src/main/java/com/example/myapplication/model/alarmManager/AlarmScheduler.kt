package com.example.myapplication.model.alarmManager

import com.example.myapplication.model.Alarm

interface AlarmScheduler {
    fun schedule(alarm: Alarm)
    fun cancel(alarm: Alarm)
}