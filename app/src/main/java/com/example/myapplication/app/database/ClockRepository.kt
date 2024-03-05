package com.example.myapplication.app.database


import android.content.Context
import androidx.room.Room
import com.example.myapplication.alarm.model.Alarm
import java.util.UUID

private const val DATABASE_NAME = "clock-database"

class ClockRepository private constructor(context: Context) {
    private val database: ClockDatabase = Room.databaseBuilder(
        context = context.applicationContext,
        klass = ClockDatabase::class.java,
        name = DATABASE_NAME
    ).addMigrations(migration_1_2, migration_2_3, migration_3_4, migration_4_5, migration_5_6)
        .addTypeConverter(Converters())
        .build()

    suspend fun getAlarms(): List<Alarm> = database.AlarmDao().getAlarms()
    suspend fun getAlarm(id: UUID): Alarm = database.AlarmDao().getAlarm(id)
    suspend fun updateAlarm(alarm: Alarm) = database.AlarmDao().updateAlarm(alarm)
    suspend fun addAlarm(alarm: Alarm) = database.AlarmDao().addAlarm(alarm)
    suspend fun deleteAlarm(alarm: Alarm) = database.AlarmDao().deleteAlarm(alarm)
    suspend fun getActiveAlarms():List<Alarm> = database.AlarmDao().getActiveAlarms()

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

