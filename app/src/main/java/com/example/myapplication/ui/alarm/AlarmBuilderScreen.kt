package com.example.myapplication.ui.alarm


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.model.Alarm
import com.example.myapplication.ui.navigation.Screen
import java.util.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlaramBuilderScreen(navController: NavController){
    var alarmState by rememberSaveable { mutableStateOf(false) }
    val alarm = Alarm(id = UUID.randomUUID(),label = "Alarm", isActive = alarmState)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("")
                },
                actions = {
                    IconButton(onClick = {
                        navController.navigate(
                            route = Screen.AlarmDetails.getId(null)
                        )
                    }){
                        Icon(imageVector = Icons.Filled.Add, contentDescription = "add")
                    }
                }
        )},
        content = {
            innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)){
                AlarmCell(
                    onClickCheckbox = {
                        alarmState = it },
                    onClickedRow = {
                        navController.navigate(route = Screen.AlarmDetails.getId(alarm.id))
                    },
                    alarm = alarm
                )
            }

        }
    )

}