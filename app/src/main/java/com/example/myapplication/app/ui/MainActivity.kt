package com.example.myapplication.app.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.alarm.model.alarmManager.AndroidAlarmScheduler
import com.example.myapplication.app.ui.navigation.SetupNavGraph


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val alarmScheduler = AndroidAlarmScheduler(this)
        setContent {
            val navController:NavHostController =  rememberNavController()
            SetupNavGraph(navController = navController, alarmScheduler = alarmScheduler)
        }
    }
}

