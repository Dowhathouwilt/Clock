package com.example.myapplication.database

import androidx.room.*
import com.example.myapplication.model.Alarm
import java.util.UUID

@Dao
interface AlarmDao {
    @Query("SELECT * From alarm")
    suspend fun getAlarms(): List<Alarm>

    @Query("SELECT * FROM alarm WHERE id=(:id)")
    suspend fun getAlarm(id: UUID): Alarm

    @Query("SELECT * From alarm Where isActive = 1")
    suspend fun getActiveAlarms():List<Alarm>

    @Update
    suspend fun updateAlarm(alarm: Alarm)

    @Insert
    suspend fun addAlarm(alarm: Alarm)

    @Delete
    suspend fun deleteAlarm(alarm: Alarm)


}