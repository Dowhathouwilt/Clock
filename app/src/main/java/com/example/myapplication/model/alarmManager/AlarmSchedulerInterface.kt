package com.example.myapplication.model.alarmManager

import com.example.myapplication.model.Alarm

interface AlarmSchedulerInterface {
    fun schedule(alarm: Alarm)
    fun cancel(alarm: Alarm)
}