package com.example.myapplication.ui.alarm


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.model.Alarm
import com.example.myapplication.model.AlarmsListViewModel
import com.example.myapplication.ui.navigation.Screen
import java.util.*


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlaramBuilderScreen(navController: NavController){

   // val alarm = Alarm(id = UUID.randomUUID(),label = "Alarm", isActive = alarmState)
    val alarmsListViewModel:AlarmsListViewModel = viewModel<AlarmsListViewModel>()
    val alarmsList = alarmsListViewModel.alarms


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
                LazyColumn {
                    itemsIndexed(items = alarmsList){iterator, alarm ->
                        AlarmCell(
                            onClickCheckbox ={
                                alarmsListViewModel.updateList(iterator = iterator, isSelected = it)
                            },
                            onClickedRow = {
                                navController.navigate(route = Screen.AlarmDetails.getId(alarm.id))
                            },
                            alarm = alarm
                        )
                    }
                }

              /*  AlarmCell(
                    onClickCheckbox = {
                        alarmState = it },
                    onClickedRow = {
                        navController.navigate(route = Screen.AlarmDetails.getId(alarm.id))
                    },
                    alarm = alarm
                )*/
            }

        }
    )

}