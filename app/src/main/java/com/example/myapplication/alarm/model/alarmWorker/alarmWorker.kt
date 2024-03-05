package com.example.myapplication.alarm.model.alarmWorker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.myapplication.app.database.ClockRepository
import com.example.myapplication.alarm.model.alarmManager.AndroidAlarmScheduler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class alarmWorker(
    private val appContext: Context,
    private val params: WorkerParameters
) : CoroutineWorker(
    appContext = appContext,
    params = params
) {
    override suspend fun doWork(): Result {
        return withContext(Dispatchers.IO) {
            val alarmScheduler = AndroidAlarmScheduler(appContext)
            val clockRepository = ClockRepository.get()
            val alarms = clockRepository.getActiveAlarms()
            if (alarms.isEmpty()) return@withContext Result.failure()
            alarms.forEach {
                alarmScheduler.schedule(it)
            }
            return@withContext Result.success()
        }
    }
}