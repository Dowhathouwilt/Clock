package com.example.myapplication.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.myapplication.alarm.model.alarmManager.AndroidAlarmScheduler
import com.example.myapplication.alarm.ui.AlaramBuilderScreen
import com.example.myapplication.alarm.ui.navigation.alarmDetailsGraph

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    alarmScheduler: AndroidAlarmScheduler
) {
    NavHost(
        navController = navController,
        startDestination = Screen.AlarmHome.route
    ) {
        composable(
            route = Screen.AlarmHome.route
        ) {
            AlaramBuilderScreen(navController, alarmScheduler)
        }
        alarmDetailsGraph(navController, alarmScheduler)
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(
    factory: ViewModelProvider.Factory?,
    navController: NavHostController
): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel(factory = factory)
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(factory = factory, viewModelStoreOwner = parentEntry)
}