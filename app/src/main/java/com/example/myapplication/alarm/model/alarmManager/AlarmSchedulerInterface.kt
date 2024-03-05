package com.example.myapplication.alarm.model.alarmManager

import com.example.myapplication.alarm.model.Alarm

interface AlarmSchedulerInterface {
    fun schedule(alarm: Alarm)
    fun cancel(alarm: Alarm)
}