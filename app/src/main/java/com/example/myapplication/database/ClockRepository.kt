package com.example.myapplication.database

import android.app.Application
import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.model.Alarm
import java.util.UUID

private const val DATABASE_NAME = "clock-database"

class ClockRepository private constructor(context:Context){
    private val database: ClockDatabase = Room.databaseBuilder(
        context = context.applicationContext,
        klass =  ClockDatabase::class.java,
        name = DATABASE_NAME
    ).build()

    suspend fun getAlarms(): List<Alarm> =  database.AlarmDao().getAlarms()
    suspend fun getAlarm(id: UUID):Alarm = database.AlarmDao().getAlarm(id)
    suspend fun updateAlarm(alarm: Alarm) = database.AlarmDao().updateAlarm(alarm)
    suspend fun addAlarm(alarm: Alarm) = database.AlarmDao().addAlarm(alarm)

    companion object {
        private var INSTANCE: ClockRepository? = null
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = ClockRepository(context)
            }
        }
        fun get(): ClockRepository {
            return INSTANCE ?: throw IllegalStateException("ClockRepository must be initialized")
        }
    }
}

