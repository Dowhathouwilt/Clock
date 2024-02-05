package com.example.myapplication.ui.alarm

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.model.AlarmDetailViewModel
import com.example.myapplication.ui.navigation.Screen

import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmDetailBuilderScreen(
    navController: NavController,
    alarmDetailViewModel: AlarmDetailViewModel
) {
    val alarmState = alarmDetailViewModel.alarm
    val alarmRepeatsState = alarmDetailViewModel.alarmRepeats

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("")
                },
                actions = {
                    Button(
                        onClick = {
                            alarmDetailViewModel.addOrUpdate(alarmState)
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
        },
        content = { innerPadding ->
            RepeatLabel(
                modifier = Modifier.padding(innerPadding),
                navController = navController,
                shortNames = alarmDetailViewModel.getStrings()
            )
            AlarmLabel(
                modifier = Modifier.padding(innerPadding),
                alarm = alarmState,
                onSetAlarmLabel = {
                    alarmDetailViewModel.updateLabel(it)
                }
            )
        }
    )
}