package com.example.myapplication.alarm.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.app.database.ClockRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AlarmsListViewModel : ViewModel() {
    private val clockRepository: ClockRepository = ClockRepository.get()
    var alarms: List<Alarm> by mutableStateOf(emptyList())
        private set

    init {
        viewModelScope.launch {
            alarms = clockRepository.getAlarms()
        }
    }

    fun updateList(iterator: Int): List<Alarm> {
        alarms = alarms.mapIndexed { j, item ->
            if (iterator == j) {
                item.copy(id = item.id, label = item.label, isActive = !item.isActive)
            } else item
        }
        updateAlarm(alarms[iterator])
        return alarms
    }

    fun deleteFromList(alarm: Alarm): List<Alarm> {
        deleteAlarm(alarm)
        alarms = alarms.minus(alarm)
        return alarms
    }

    private fun updateAlarm(alarm: Alarm) {
        viewModelScope.launch(Dispatchers.IO) {
            clockRepository.updateAlarm(alarm)
        }
    }

    private fun deleteAlarm(alarm: Alarm) {
        viewModelScope.launch(Dispatchers.IO) {
            clockRepository.deleteAlarm(alarm)
        }
    }

}