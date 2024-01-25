package com.example.myapplication.ui.alarm


import androidx.compose.foundation.layout.*

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*

import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.model.AlarmsListViewModel
import com.example.myapplication.ui.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlaramBuilderScreen(navController: NavController){

    var toDelete: Boolean by remember{mutableStateOf(false)}
    val alarmsListViewModel:AlarmsListViewModel = viewModel<AlarmsListViewModel>()
    val alarmsList = alarmsListViewModel.alarms


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("")
                },
                actions = {
                    Row {
                        Button(
                            onClick = { toDelete = !toDelete },
                            content = {
                                if (toDelete) Text(text = "Done")
                                else Text(text = "Edit")
                            }
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        IconButton(
                            onClick = { navController.navigate(route = Screen.AlarmDetails.getId(null)) },
                            content = { Icon(imageVector = Icons.Filled.Add, contentDescription = "add") }
                        )
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
                                alarmsListViewModel.updateList(iterator = iterator)
                            },
                            onClickedRow = {
                                navController.navigate(route = Screen.AlarmDetails.getId(alarm.id))
                            },
                            toDelete = toDelete,
                            onDeleteAlarm = {
                                alarmsListViewModel.deleteFromList(alarm)
                            },
                            alarm = alarm
                        )
                    }
                }
            }
        }
    )
}