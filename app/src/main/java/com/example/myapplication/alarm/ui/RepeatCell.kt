package com.example.myapplication.alarm.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.alarm.model.Repeat


@Composable
fun RepeatCell(
    modifier: Modifier,
    isPicked:Boolean,
    repeat: Repeat,
    onPressed: () -> Unit
) {

    Row(
        modifier = modifier.fillMaxWidth().clickable {
            onPressed()
        },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    )
    {
        Text(modifier = Modifier.padding(start = 16.dp), text = stringResource(repeat.repeatName))
        Spacer(modifier = Modifier.weight(1f))
        if (isPicked)
        Image(
            modifier = Modifier.padding(end = 16.dp),
            imageVector = Icons.Default.Done,
            contentDescription = "Added"
        )
    }

}