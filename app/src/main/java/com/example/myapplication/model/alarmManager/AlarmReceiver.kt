package com.example.myapplication.model.alarmManager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.example.myapplication.database.ClockRepository
import com.example.myapplication.model.notificationManager.AlarmNotificationManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.UUID
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext


class AlarmReceiver : BroadcastReceiver() {
    private val clockRepository: ClockRepository = ClockRepository.get()

    override fun onReceive(context: Context, intent: Intent) {

    }

    //TODO: Set a rescheduling alarms  booting up database logic (here?)  and a rescheduling alarms to next date
    private fun BroadcastReceiver.goAsync(
        context: CoroutineContext = EmptyCoroutineContext,
        block: suspend CoroutineScope.() -> Unit
    ) {
        val pendingResult = goAsync()
        @OptIn(DelicateCoroutinesApi::class) // Must run globally; there's no teardown callback.
        GlobalScope.launch(context) {
            try {
                block()
            } finally {
                pendingResult.finish()
            }
        }
    }
}