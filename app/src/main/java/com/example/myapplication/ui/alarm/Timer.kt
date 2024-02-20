package com.example.myapplication.ui.alarm

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.chargemap.compose.numberpicker.NumberPicker


@Composable
fun Timer(
    hour: Int,
    minute: Int,
    onChangeHour: (Int) -> Unit,
    onChangeMinute: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    Row(modifier = modifier) {
        NumberPicker(
            range = 0..24,
            value = hour,
            onValueChange = {
                onChangeHour(it)
            }
        )
        Spacer(modifier = Modifier.padding(10.dp))
        NumberPicker(
            range = 0..60,
            value = minute,
            onValueChange = {
                onChangeMinute(it)
            }
        )
    }
}