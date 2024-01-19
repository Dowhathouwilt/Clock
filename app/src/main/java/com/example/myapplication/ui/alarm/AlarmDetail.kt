package com.example.myapplication.ui.alarm

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    onSetAlarmLabel: () -> Unit
){
    Column( modifier = modifier
        .fillMaxWidth()
        .padding(all = 10.dp)) {
        Row(
            modifier = Modifier.clickable {
                onSetAlarmLabel()
            },
        ) {
            Text(text = "Label")
            Spacer(modifier = Modifier.weight(1f))
            Text(text = alarm.label)
        }
    }
}