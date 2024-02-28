package com.example.myapplication.ui.alarm

import android.provider.ContactsContract.CommonDataKinds.StructuredName
import androidx.compose.foundation.layout.*

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.myapplication.model.Alarm

@Composable
fun Content(
    modifier: Modifier,
    navController: NavController,
    alarmState: Alarm,
    shortName: String,
    onChangeHour: (Int) -> Unit,
    onChangeMinute: (Int) -> Unit,
    onLabelChange: (String) -> Unit
) {
    Column   (
        modifier = modifier.fillMaxWidth().fillMaxHeight()
    ) {
        Timer(
            hour = alarmState.hour,
            minute = alarmState.minute,
            modifier = Modifier,
            onChangeHour = {
                onChangeHour(it)
            },
            onChangeMinute = {
                onChangeMinute(it)
            }
        )
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            RepeatLabel(
                modifier = Modifier.padding(),
                navController = navController,
                shortNames = shortName
            )
            AlarmLabel(
                modifier = Modifier.padding(),
                alarm = alarmState,
                onSetAlarmLabel = {
                    onLabelChange(it)
                }
            )
        }
    }
}