package com.example.myapplication.ui.alarm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.model.Repeat

@Composable
fun RepeatsBuilderScreen() {
    Column {
        LazyColumn {
            itemsIndexed(Repeat.entries.toTypedArray()) { index, repeat ->
                RepeatCell(modifier = Modifier, repeat = repeat, onPressed = {

                })
            }
        }
    }
}
