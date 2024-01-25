package com.example.myapplication.ui.alarm

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.Alarm
import java.util.*

@Preview
@Composable
fun AlarmDetailPreview(){
    AlarmDetail(alarm = Alarm(id = UUID.randomUUID(),
        label = "Alarm",  isActive = false ), onSetAlarmLabel = {})
}


@Composable
fun AlarmDetail(
    alarm: Alarm,
    modifier: Modifier = Modifier,
    onSetAlarmLabel: (String) -> Unit
){
    val focusManager = LocalFocusManager.current
    Column( modifier = modifier
        .fillMaxWidth()
        .padding(all = 8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
            TextField(
                value = alarm.label,
                onValueChange = {
                    onSetAlarmLabel(it)
                },
                textStyle = LocalTextStyle.current.copy(
                    textAlign = TextAlign.Right
                ),
                leadingIcon = {
                    Text("Label")
                },
                trailingIcon = {
                    if (alarm.label.isNotEmpty()){
                        IconButton(
                            onClick = {onSetAlarmLabel("")},
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
            )
    }
}