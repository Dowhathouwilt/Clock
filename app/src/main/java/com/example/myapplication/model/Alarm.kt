package com.example.myapplication.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class Alarm(
   @PrimaryKey val id: UUID,
    val label: String = "Alarm",
    val isActive: Boolean = false
)

