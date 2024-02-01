package com.example.myapplication.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.core.app.NavUtils
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.myapplication.model.AlarmDetailViewModel
import com.example.myapplication.model.AlarmDetailViewModelFactory
import com.example.myapplication.ui.alarm.AlaramBuilderScreen
import com.example.myapplication.ui.alarm.AlarmDetailBuilderScreen
import com.example.myapplication.ui.alarm.RepeatsBuilderScreen
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
            val id:UUID? = when (it.arguments?.getString(ALARM_DETAILS_ARGUMENT)){
                null -> null
                else -> {
                    UUID.fromString(it.arguments?.getString(ALARM_DETAILS_ARGUMENT))
                }
            }
            val sharedViewModel = it.sharedViewModel<AlarmDetailViewModel>(factory = AlarmDetailViewModelFactory(id), navController)
            AlarmDetailBuilderScreen(
                id = id,
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

@Composable
inline fun <reified T:ViewModel> NavBackStackEntry.sharedViewModel(
    factory: ViewModelProvider.Factory?,
    navController: NavHostController
):T{
    val navGraphRoute = destination.parent?.route ?:return viewModel(factory = factory)
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(factory = factory, viewModelStoreOwner = parentEntry)
}