package com.example.myapplication.model

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.TemporalAdjuster
import java.time.temporal.TemporalAdjusters

class AlarmTimeWorker(private val alarm: Alarm) {

    fun findNearestDate() {
        val dayNumber: List<Int> = alarm.repeat.map { repeat ->
            repeat.dayNumber
        }

    }
    fun getTime(): LocalTime {
        return LocalTime.of(alarm.hour,alarm.minute)
    }


}