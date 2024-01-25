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

class AlarmDetailViewModel(alarmId:UUID?): ViewModel() {
    private val clockRepository:ClockRepository = ClockRepository.get()
    var alarm by mutableStateOf(Alarm(id = UUID.randomUUID()))
        private set

    init {
        viewModelScope.launch {
            alarm = if (alarmId == null) {
                alarm
            }else{
                clockRepository.getAlarm(alarmId)
            }
        }
    }

    fun addAlarm(alarm: Alarm){
        viewModelScope.launch (Dispatchers.IO) {
            clockRepository.addAlarm(alarm = alarm)
        }
    }

    fun updateAlarm(alarm: Alarm){
        viewModelScope.launch (Dispatchers.IO) {
            clockRepository.updateAlarm(alarm)
        }
    }

    fun updateUI(label: String):Alarm{
        alarm = alarm.copy(id = alarm.id, label = label)
        return alarm
    }
}

class AlarmDetailViewModelFactory(private val alarmId: UUID?):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        return AlarmDetailViewModel(alarmId) as T
    }
}