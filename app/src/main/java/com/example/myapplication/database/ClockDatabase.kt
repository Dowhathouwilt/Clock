package com.example.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.model.Alarm

@Database(entities = [Alarm::class], version = 1)
abstract class ClockDatabase: RoomDatabase() {
    abstract fun AlarmDao():AlarmDao
}