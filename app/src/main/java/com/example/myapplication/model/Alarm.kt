package com.example.myapplication.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import java.util.UUID

@Entity
data class Alarm(
    @PrimaryKey(autoGenerate = false)
    val id: UUID,
    val label: String = "Alarm",
    val isActive: Boolean = false,
    val repeat: String? = null
)

@Entity
data class AlarmRepeat(
    val day: Int,
    @PrimaryKey(autoGenerate = false)
    val alarmId: UUID
)

