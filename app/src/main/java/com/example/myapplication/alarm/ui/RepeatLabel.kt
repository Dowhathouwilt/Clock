package com.example.myapplication.alarm.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.myapplication.app.ui.navigation.Screen

@Composable
fun RepeatLabel(modifier: Modifier, navController: NavController, shortNames: String) {

    Row(modifier = modifier.clickable {
        navController.navigate(Screen.AlarmRepeatsScreen.route)
    }) {
        OutlinedTextField(
            modifier = Modifier,
            value = shortNames,
            onValueChange = {
            },

            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Right,
            ),
            leadingIcon = {
                Text("Label")
            },
            singleLine = true,
            enabled = false
        )
    }
}
