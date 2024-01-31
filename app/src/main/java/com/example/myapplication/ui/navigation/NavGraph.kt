package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.core.app.NavUtils
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.myapplication.ui.alarm.AlaramBuilderScreen
import com.example.myapplication.ui.alarm.AlarmDetailBuilderScreen
import java.util.IllegalFormatConversionException
import java.util.UUID

@Composable
fun SetupNavGraph(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.AlarmHome.route
    ) {
        composable(
            route = Screen.AlarmHome.route
        ) {
            AlaramBuilderScreen(navController)
        }
        composable(
            arguments = listOf(navArgument(ALARM_DETAILS_ARGUMENT) {
                type = NavType.StringType
                nullable = true
            }),
            route = Screen.AlarmDetails.route
        ) {
            val id = it.arguments?.getString(ALARM_DETAILS_ARGUMENT)
            AlarmDetailBuilderScreen(
                id = when (id) {
                    null -> null
                    else -> {
                        UUID.fromString(id)
                    }
                }, navController = navController
            )
        }
    }
}
