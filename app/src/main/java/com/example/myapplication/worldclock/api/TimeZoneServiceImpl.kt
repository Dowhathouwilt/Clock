package com.example.myapplication.worldclock.api


import com.example.myapplication.worldclock.model.AreaTime
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class TimeZoneServiceImpl(
    private val client: HttpClient
) : TimeZoneService {

    override suspend fun getAllTimeZones(): List<String> {
        val route = HttpRoutes.TIME_ZONE
        try {
            val timeZoneAreas: List<String> = client.get(route).bodyAsText()
                .removePrefix("[")
                .removeSuffix("]")
                .split(",")
                .map {
                    it.drop(1).dropLast(1)
                }
            return timeZoneAreas
        } catch (re: RedirectResponseException) {
            throw re
        } catch (ce: ClientRequestException) {
            throw ce
        } catch (se: ServerResponseException) {
            throw se
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getTimeZoneAreas(timeZone: String): List<String> {
        val route: String = HttpRoutes.getAreaLocation(timeZone)
        try {
            val timeZoneAreas: List<String> = client.get(route).bodyAsText()
                .removePrefix("[")
                .removeSuffix("]")
                .split(",")
                .map {
                    it.drop(1).dropLast(1)
                }
            return timeZoneAreas
        } catch (re: RedirectResponseException) {
            throw re
        } catch (ce: ClientRequestException) {
            throw ce
        } catch (se: ServerResponseException) {
            throw se
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getAreaTime(area: String): AreaTime {
        val route: String = HttpRoutes.getAreaLocation(area)
        try {
            val areaTime: AreaTime = client.get(route).body()
            return areaTime
        } catch (re: RedirectResponseException) {
            throw re
        } catch (ce: ClientRequestException) {
            throw ce
        } catch (se: ServerResponseException) {
            throw se
        } catch (e: Exception) {
            throw e
        }
    }
}