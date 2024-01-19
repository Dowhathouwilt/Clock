package com.example.myapplication.ui.alarm

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.Alarm
import java.util.*

@Preview
@Composable
fun AlarmCellPreview(){
    AlarmCell(onClickCheckbox = {},
        onClickedRow = {},
        alarm = Alarm(id = UUID.randomUUID(),"Alarm", isActive = false) )
}

@Composable
fun AlarmCell(
    onClickCheckbox: (Boolean) -> Unit,
    onClickedRow: () -> Unit,
    alarm: Alarm
){
    Row(modifier = Modifier
        .padding(10.dp)
        .clickable { onClickedRow() },
        verticalAlignment = Alignment.CenterVertically
    ){
        Column {
            Text(text = "10:30",
                style = MaterialTheme.typography.bodyMedium)
            Text(text = alarm.label,
                style = MaterialTheme.typography.bodySmall)
        }
        Checkbox(onCheckedChange = onClickCheckbox, checked = alarm.isActive)
    }
}