package com.example.myapplication.ui.alarm

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.myapplication.model.AlarmDetailViewModel
import com.example.myapplication.model.alarmManager.AndroidAlarmScheduler
import com.example.myapplication.ui.navigation.Screen



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmDetailBuilderScreen(
    navController: NavController,
    alarmScheduler: AndroidAlarmScheduler,
    alarmDetailViewModel: AlarmDetailViewModel
) {
    val alarmState = alarmDetailViewModel.alarm

    Column {
        TopAppBar(
            title = {
                Text("")
            },
            actions = {
                Button(
                    onClick = {
                        alarmDetailViewModel.addOrUpdate(alarmState)
                        if (alarmState.isActive) alarmScheduler.schedule(alarmState)
                        navController.navigate(
                            route = Screen.AlarmHome.route
                        ) {
                            popUpTo(Screen.AlarmHome.route) {
                                inclusive = true
                            }
                        }
                    },
                    content = { Text(text = "Save") }
                )
            }
        )
        Content(
            navController = navController,
            modifier = Modifier.padding(),
            alarmState = alarmState,
            shortName = alarmDetailViewModel.getShortNames(alarmState),
            onChangeHour = { alarmDetailViewModel.setHour(it) },
            onChangeMinute = { alarmDetailViewModel.setMinute(it) },
            onLabelChange = { alarmDetailViewModel.updateLabel(it) }
        )
    }
}