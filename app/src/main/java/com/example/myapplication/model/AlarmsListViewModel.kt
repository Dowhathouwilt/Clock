package com.example.myapplication.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.util.copy
import com.example.myapplication.database.ClockRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class AlarmsListViewModel: ViewModel() {
    private val clockRepository: ClockRepository = ClockRepository.get()

    var alarms: List<Alarm> by mutableStateOf(emptyList())
        private set

    init {
        viewModelScope.launch {
            alarms = clockRepository.getAlarms()
        }
    }

     fun updateList(iterator: Int):List<Alarm>{
        alarms = alarms.mapIndexed{ j, item ->
            if (iterator == j){
                item.copy(id = item.id, label = item.label, isActive = !item.isActive)
            } else item
        }
        return alarms
    }

    fun deleteAlarm(alarm: Alarm){
        viewModelScope.launch {
            clockRepository.deleteAlarm(alarm)
        }
        deleteFromList(alarm)
    }

    private fun deleteFromList(alarm: Alarm):List<Alarm>{
        alarms = alarms.minus(alarm)
        return alarms
    }


    fun updateAlarm(alarm: Alarm){
        viewModelScope.launch {
            clockRepository.updateAlarm(alarm)
        }
    }

}