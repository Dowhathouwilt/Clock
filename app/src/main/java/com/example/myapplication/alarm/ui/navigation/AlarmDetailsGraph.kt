package com.example.myapplication.alarm.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.myapplication.alarm.model.AlarmDetailViewModel
import com.example.myapplication.alarm.model.AlarmDetailViewModelFactory
import com.example.myapplication.alarm.model.alarmManager.AndroidAlarmScheduler
import com.example.myapplication.alarm.ui.AlarmDetailBuilderScreen
import com.example.myapplication.alarm.ui.RepeatsBuilderScreen
import com.example.myapplication.app.ui.navigation.ALARM_DETAILS_ARGUMENT
import com.example.myapplication.app.ui.navigation.Screen
import com.example.myapplication.app.ui.navigation.sharedViewModel
import java.util.*

fun NavGraphBuilder.alarmDetailsGraph(navController: NavHostController, alarmScheduler: AndroidAlarmScheduler) {
    navigation(
        startDestination = Screen.AlarmDetails.route,
        route = Screen.AlarmDetailsGraph.route,
        arguments = listOf(navArgument(ALARM_DETAILS_ARGUMENT) {
            type = NavType.StringType
            nullable = true
        })
    ) {
        composable(
            route = Screen.AlarmDetails.route
        ) {
            val id: UUID? = when (it.arguments?.getString(ALARM_DETAILS_ARGUMENT)) {
                null -> null
                else -> {
                    UUID.fromString(it.arguments?.getString(ALARM_DETAILS_ARGUMENT))
                }
            }
            val sharedViewModel = it.sharedViewModel<AlarmDetailViewModel>(
                factory = AlarmDetailViewModelFactory(id),
                navController = navController
            )
            AlarmDetailBuilderScreen(
                alarmDetailViewModel = sharedViewModel,
                alarmScheduler = alarmScheduler,
                navController = navController
            )
        }
        composable(
            route = Screen.AlarmRepeatsScreen.route,
        ) {
            val id: UUID? = when (it.arguments?.getString(ALARM_DETAILS_ARGUMENT)) {
                null -> null
                else -> {
                    UUID.fromString(it.arguments?.getString(ALARM_DETAILS_ARGUMENT))
                }
            }
            val sharedViewModel = it.sharedViewModel<AlarmDetailViewModel>(
                factory = AlarmDetailViewModelFactory(id),
                navController = navController
            )
            RepeatsBuilderScreen(sharedViewModel)
        }
    }
}