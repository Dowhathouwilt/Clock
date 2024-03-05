package com.example.myapplication.worldclock.api

import com.example.myapplication.worldclock.model.AreaTime

interface TimeZoneService {
    suspend fun getAllTimeZones():List<String>
    suspend fun getTimeZoneAreas(timeZone: String):List<String>
    suspend fun getAreaTime(area: String): AreaTime
}