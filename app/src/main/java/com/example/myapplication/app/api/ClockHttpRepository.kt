package com.example.myapplication.app.api

import com.example.myapplication.worldclock.api.TimeZoneServiceImpl
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json


class ClockHttpRepository {

    private val client: HttpClient = HttpClient(Android) {
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.BODY
        }
        install(ContentNegotiation) {
            json(
                Json {
                    ignoreUnknownKeys = true
                }
            )
        }
    }
    private val timeZoneService: TimeZoneServiceImpl = TimeZoneServiceImpl(client)

    suspend fun getAllTimeZones() = timeZoneService.getAllTimeZones()
    suspend fun getTimeZoneAreas(timeZone: String) = timeZoneService.getTimeZoneAreas(timeZone)
    suspend fun getAreaTime(area: String) = timeZoneService.getAreaTime(area)

    companion object {

        private var INSTANCE: ClockHttpRepository? = null

        fun initialize() {
            if (INSTANCE == null) {
                INSTANCE = ClockHttpRepository()
            }
        }

        fun get(): ClockHttpRepository {
            return INSTANCE ?: throw IllegalStateException("HttpClient must be initialized")
        }
    }
}