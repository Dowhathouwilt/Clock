package com.example.myapplication.alarm.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Alarm(
    @PrimaryKey(autoGenerate = false)
    val id: UUID,
    val hour: Int = 0,
    val minute: Int = 0,
    val label: String = "Alarm",
    val isActive: Boolean = false,
    val repeat: List<Repeat> = emptyList()
): Parcelable

