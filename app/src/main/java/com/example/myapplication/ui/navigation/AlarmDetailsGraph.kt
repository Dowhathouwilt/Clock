package com.example.myapplication.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.myapplication.model.AlarmDetailViewModel
import com.example.myapplication.model.AlarmDetailViewModelFactory
import com.example.myapplication.ui.alarm.AlarmDetailBuilderScreen
import com.example.myapplication.ui.alarm.RepeatsBuilderScreen
import java.util.*

fun NavGraphBuilder.alarmDetailsGraph(navController: NavHostController) {
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
                navController = navController
            )
        }
        composable(
            route = Screen.AlarmRepeatsScreen.route,
        ) {
            RepeatsBuilderScreen()
        }
    }
}