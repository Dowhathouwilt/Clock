package com.example.myapplication.ui.alarm

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.myapplication.model.Alarm
import com.example.myapplication.model.AlarmDetailViewModel
import com.example.myapplication.model.AlarmDetailViewModelFactory
import com.example.myapplication.ui.navigation.Screen

import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlarmDetailBuilderScreen(id: UUID?, navController: NavController){
    val alarmDetailViewModel: AlarmDetailViewModel = viewModel<AlarmDetailViewModel>(factory = AlarmDetailViewModelFactory(id))
    val alarmState = alarmDetailViewModel.alarm

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("")
                },
                actions = {
                        Button(onClick = {
                            when(id){
                                null -> alarmDetailViewModel.addAlarm(alarmState)
                                else -> alarmDetailViewModel.updateAlarm(alarmState)
                            }
                            navController.navigate(
                                route = Screen.AlarmHome.route
                            ){
                                popUpTo(Screen.AlarmHome.route){
                                    inclusive = true
                                }
                            }
                        },
                            content = {
                                Text(text = "Save")
                            }
                        )
                }
            )
        },
        content = {
            innerPadding ->
            AlarmDetail(modifier = Modifier.padding(innerPadding), alarm = alarmState, onSetAlarmLabel = {
                alarmDetailViewModel.updateUI(it)
            })
        }
    )
}