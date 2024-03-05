package com.example.myapplication.alarm.database

import androidx.room.*
import com.example.myapplication.alarm.model.Alarm
import java.util.UUID

@Dao
interface AlarmDao {
    @Query("SELECT * FROM alarm")
    suspend fun getAlarms(): List<Alarm>

    @Query("SELECT * FROM alarm WHERE id=(:id)")
    suspend fun getAlarm(id: UUID): Alarm

    @Query("SELECT * FROM alarm WHERE isActive = 1")
    suspend fun getActiveAlarms():List<Alarm>

    @Update
    suspend fun updateAlarm(alarm: Alarm)

    @Insert
    suspend fun addAlarm(alarm: Alarm)

    @Delete
    suspend fun deleteAlarm(alarm: Alarm)
}