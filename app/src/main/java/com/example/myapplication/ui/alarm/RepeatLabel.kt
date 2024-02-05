package com.example.myapplication.ui.alarm

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.myapplication.ui.navigation.Screen

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
