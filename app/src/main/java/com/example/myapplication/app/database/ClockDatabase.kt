package com.example.myapplication.app.database


import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myapplication.alarm.database.AlarmDao
import com.example.myapplication.alarm.model.Alarm


@Database(
    entities = [
        Alarm::class], version = 6
)
@TypeConverters(Converters::class)
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

val migration_3_4 = object : Migration(3, 4) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("DROP TABLE alarmRepeat")
    }
}
val migration_4_5 = object : Migration(4, 5) {
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("DROP TABLE alarm")
        db.execSQL("CREATE TABLE IF NOT EXISTS `Alarm` (`id` BLOB NOT NULL PRIMARY KEY, 'label' TEXT NOT NULL, 'isActive' INTEGER NOT NULL, 'repeat' TEXT NOT NULL DEFAULT '')")
    }
}
val migration_5_6 = object:Migration(5,6){
    override fun migrate(db: SupportSQLiteDatabase) {
        db.execSQL("ALTER TABLE Alarm ADD COLUMN hour INTEGER NOT NULL")
        db.execSQL("ALTER TABLE Alarm ADD COLUMN minute INTEGER NOT NULL")
    }
}



