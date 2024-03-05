package com.example.myapplication.worldclock.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class AreaTime(
    @SerialName("abbreviation")
    val abbreviation: String,
    @SerialName("datetime")
    val datetime: String,
    @SerialName("day_of_week")
    val dayOfWeek: Int,
    @SerialName("day_of_year")
    val dayOfYear: Int,
    @SerialName("dst")
    val dst: Boolean?,
    @SerialName("dst_from")
    val dstFrom: String?,
    @SerialName("dst_offset")
    val dstOffset: Int,
    @SerialName("dst_until")
    val dstUntil: String?,
    @SerialName("raw_offset")
    val rawOffset: Int,
    @SerialName("timezone")
    val timezone: String,
    @SerialName("unixtime")
    val unixTime: Int,
    @SerialName("utc_datetime")
    val utcDatetime: String,
    @SerialName("utc_offset")
    val utcOffset: String,
    @SerialName("week_number")
    val weekNumber: Int
)