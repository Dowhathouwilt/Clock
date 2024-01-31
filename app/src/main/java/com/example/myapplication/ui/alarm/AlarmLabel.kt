package com.example.myapplication.ui.alarm

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.model.Alarm
import java.util.*

@Composable
fun AlarmLabel(
    alarm: Alarm,
    modifier: Modifier = Modifier,
    onSetAlarmLabel: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    Row(modifier = modifier) {
        OutlinedTextField(
            modifier = modifier,
            value = alarm.label,
            onValueChange = {
                onSetAlarmLabel(it)
            },
            textStyle = LocalTextStyle.current.copy(
                textAlign = TextAlign.Right,
            ),
            placeholder = {
                Text("Alarm")
            },
            leadingIcon = {
                Text("Label")
            },
            trailingIcon = {
                if (alarm.label.isNotEmpty()) {
                    IconButton(
                        onClick = { onSetAlarmLabel("") },
                        content = {
                            Image(imageVector = Icons.Default.Clear, contentDescription = "Clear")
                        }
                    )
                }
            },
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.clearFocus()
                }
            ),
            singleLine = true
        )
    }
}