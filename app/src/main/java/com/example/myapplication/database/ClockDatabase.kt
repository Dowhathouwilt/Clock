package com.example.myapplication.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myapplication.model.Alarm
import com.example.myapplication.model.AlarmRepeat

@Database(
    entities = [
        Alarm::class,
        AlarmRepeat::class], version = 3
)
abstract class ClockDatabase : RoomDatabase() {
    abstract fun AlarmDao(): AlarmDao
}

val migration_1_2 = object : Migration(1, 2) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL(
            "ALTER TABLE Alarm ADD COLUMN repeat TEXT DEFAULT NULL"
        )
    }
}
val migration_2_3 = object : Migration(2, 3) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `AlarmRepeat` (`alarmId` BLOB NOT NULL PRIMARY KEY, 'day' INTEGER NOT NULL)")
    }
}