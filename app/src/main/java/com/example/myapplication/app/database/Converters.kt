package com.example.myapplication.app.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.myapplication.alarm.model.Repeat


@ProvidedTypeConverter
class Converters {
    @TypeConverter
    fun fromListRepeatToString(value: List<Repeat>): String {
        return when (value) {
            emptyList<Repeat>() -> ""
            else -> value.toString().removePrefix("[").removeSuffix("]")
        }
    }

    @TypeConverter
    fun fromStringToListRepeat(value: String): List<Repeat> {
        return when (value) {
            "" -> emptyList()
            else -> value.split(", ").map {
                Repeat.valueOf(it)
            }
        }
    }
}