package com.example.myapplication.model.utils

import com.example.myapplication.model.Alarm
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.Calendar

class AlarmTimeWorker(private val alarm: Alarm) {

    val calendar: Calendar = Calendar.getInstance()

    init {
        calendar.apply {
            add(Calendar.DATE, getNearestDay())
            set(Calendar.HOUR_OF_DAY, alarm.hour)
            set(Calendar.MINUTE, alarm.minute)
            set(Calendar.SECOND, 0)
        }
    }

    private fun getNearestDay(): Int {
        val alarmDays: List<Int> = alarm.repeat.map { it.dayNumber }.sorted()
        val currentDay: Int = LocalDate.now().dayOfWeek.value
        val alarmTime: LocalTime = LocalTime.of(alarm.hour, alarm.minute)
        val currentTime: LocalTime = LocalTime.now()
        return if ((alarmDays.contains(currentDay) or alarmDays.isEmpty()) and (currentTime < alarmTime)) {
            0
        } else {
            nearestDate(currentDay = currentDay, dates = alarmDays)
        }
    }

    private fun nearestDate(currentDay: Int, dates: List<Int>): Int {
        when (dates.isEmpty()) {
            true -> return 1
            else -> {
                var nearestDate: Int = dates[0]
                for (i in dates) {
                    if (i - currentDay > 0) {
                        nearestDate = i
                        break
                    }
                }
                return daysToAdd(currentDay = currentDay, nearestDay = nearestDate)
            }
        }
    }

    private fun daysToAdd(currentDay: Int, nearestDay: Int): Int {
        if (currentDay < nearestDay) return nearestDay - currentDay
        return 7 - currentDay + nearestDay
    }
}