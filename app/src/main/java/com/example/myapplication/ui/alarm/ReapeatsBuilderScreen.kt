package com.example.myapplication.ui.alarm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.myapplication.model.AlarmDetailViewModel
import com.example.myapplication.model.Repeat

@Composable
fun RepeatsBuilderScreen(viewModel: AlarmDetailViewModel) {
    Column {
        LazyColumn {
            items(Repeat.entries) { repeat ->
                RepeatCell(modifier = Modifier, repeat = repeat, isPicked = viewModel.containsRepeat(repeat), onPressed = {
                    viewModel.addOrDeleteRepeat(repeat)
                })
            }
        }
    }
}
