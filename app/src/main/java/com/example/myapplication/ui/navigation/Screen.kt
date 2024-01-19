package com.example.myapplication.ui.navigation

import java.util.UUID

const val ALARM_DETAILS_ARGUMENT = "id"
sealed class Screen(val route: String) {
    data object AlarmHome: Screen(route = "alarmHome_screen")
    data object AlarmDetails: Screen(route = "alarmDetail_screen/{$ALARM_DETAILS_ARGUMENT}"){
        fun getId(id: UUID?):String{
           return "alarmDetail_screen/$id"
        }
    }
}