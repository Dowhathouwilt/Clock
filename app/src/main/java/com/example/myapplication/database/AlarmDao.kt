package com.example.myapplication.database

import androidx.room.*
import com.example.myapplication.model.Alarm
import com.example.myapplication.model.AlarmRepeat
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

    @Query("SELECT * FROM alarmrepeat WHERE alarmId=(:alarmId)")
    suspend fun getAlarmRepeats(alarmId:UUID): List<AlarmRepeat>

    @Query("SELECT * FROM alarmrepeat WHERE day=(:day)")
    suspend fun getAlarmRepeats(day:Int): List<AlarmRepeat>

    @Insert
    suspend fun insertAlarmRepeat(alarmRepeats: List<AlarmRepeat>)

    @Delete
    suspend fun deleteRepeats(alarmRepeats: List<AlarmRepeat>)
}