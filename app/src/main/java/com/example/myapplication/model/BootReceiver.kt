package com.example.myapplication.model

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.myapplication.model.alarmWorker.alarmWorker

class BootReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        if (intent?.action == Intent.ACTION_BOOT_COMPLETED) {
            println("Boot started")
            val workManager = WorkManager.getInstance(context)
            val workRequest: WorkRequest = OneTimeWorkRequestBuilder<alarmWorker>().build()
            workManager.enqueue(workRequest)
        }
    }
}