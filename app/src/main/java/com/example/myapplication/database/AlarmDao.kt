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

    @Update
    suspend fun updateAlarm(alarm: Alarm)

    @Insert
    suspend fun addAlarm(alarm: Alarm)

    @Delete
    suspend fun deleteAlarm(alarm: Alarm)

}