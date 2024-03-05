package com.example.myapplication.worldclock.api

object HttpRoutes {
    private const val BASE_URL = "https://worldtimeapi.org/api"
    const val TIME_ZONE = "$BASE_URL/timezone"

    fun getAreaLocation(timeZone: String): String {
        return "$TIME_ZONE/$timeZone/"
    }
}