package com.example.myapplication.ui.alarm

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.room.Delete
import com.example.myapplication.model.Alarm
import java.util.*


@Composable
fun AlarmCell(
    onClickCheckbox: (Boolean) -> Unit,
    onClickedRow: () -> Unit,
    onDeleteAlarm: () -> Unit,
    toDelete: Boolean,
    alarm: Alarm
){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(15.dp)
        .clickable { onClickedRow() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row(verticalAlignment = Alignment.CenterVertically) {
            if (toDelete) {
                IconButton(
                    onClick = { onDeleteAlarm() },
                    content = { Icon(imageVector = Icons.Filled.Delete, contentDescription = "delete") }
                )
            }
            Column {
                Text(text = "10:30",
                    style = MaterialTheme.typography.titleLarge)
                Text(text = alarm.label,
                    style = MaterialTheme.typography.titleSmall)
            }
        }
        Checkbox(onCheckedChange = onClickCheckbox, checked = alarm.isActive)
    }
}