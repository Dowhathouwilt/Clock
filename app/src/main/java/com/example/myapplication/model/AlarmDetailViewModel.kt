package com.example.myapplication.model


import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
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

    @Composable
    fun getShortNames(alarm: Alarm): String {
        val shortName: String = when (alarm.repeat.size) {
            0 -> "Never"
            Repeat.entries.size -> "Every Day"
            else -> alarm.repeat.map {
                stringResource(it.shortName)
            }.toString().removePrefix("[").removeSuffix("]")
        }
        return shortName
    }

    fun setHour(hour: Int): Alarm {
        alarm = alarm.copy(id = alarm.id, hour = hour)
        return alarm
    }
    fun setMinute(minute: Int): Alarm {
        alarm = alarm.copy(id = alarm.id, minute = minute)
        return alarm
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