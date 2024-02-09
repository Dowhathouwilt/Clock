package com.example.myapplication.model


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.myapplication.database.ClockRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.UUID

class AlarmDetailViewModel(private val alarmId: UUID?) : ViewModel() {
    private val clockRepository: ClockRepository = ClockRepository.get()
    var alarm by mutableStateOf(Alarm(id = UUID.randomUUID()))
        private set

    init {
        viewModelScope.launch {
            alarm = if (alarmId == null) {
                alarm
            } else {
                clockRepository.getAlarm(alarmId)
            }
        }
    }

    fun addOrUpdate(alarm: Alarm) {
        when (alarmId) {
            null -> addAlarm(alarm)
            else -> updateAlarm(alarm)
        }
    }

    fun updateLabel(label: String): Alarm {
        alarm = alarm.copy(id = alarm.id, label = label)
        return alarm
    }

    fun addOrDeleteRepeat(repeat: Repeat): Alarm {
        alarm = when (containsRepeat(repeat)) {
            true -> alarm.copy(id = alarm.id, repeat = alarm.repeat.minus(repeat))
            false -> alarm.copy(id = alarm.id, repeat = alarm.repeat.plus(repeat))
        }
        return alarm
    }

    fun containsRepeat(repeat: Repeat): Boolean {
        return alarm.repeat.contains(repeat)
    }

    private fun addAlarm(alarm: Alarm) {
        viewModelScope.launch(Dispatchers.IO) {
            clockRepository.addAlarm(alarm = alarm)
        }
    }

    private fun updateAlarm(alarm: Alarm) {
        viewModelScope.launch(Dispatchers.IO) {
            clockRepository.updateAlarm(alarm)
        }
    }
}

class AlarmDetailViewModelFactory(private val alarmId: UUID?) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AlarmDetailViewModel(alarmId) as T
    }
}